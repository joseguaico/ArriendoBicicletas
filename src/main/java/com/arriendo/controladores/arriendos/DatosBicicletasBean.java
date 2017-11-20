
package com.arriendo.controladores.arriendos;

import com.arriendo.modelos.Bicicleta;
import com.arriendo.modelos.Cliente;
import com.arriendo.modelos.Marca;
import com.arriendo.modelos.Sucursal;
import com.arriendo.utilidades.Utilidades;
import com.arriendos.gestores.GestionBicicletas;
import com.arriendos.gestores.GestionClientes;
import com.arriendos.gestores.GestionMarcas;
import com.arriendos.gestores.GestionSucursales;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.commons.lang.StringUtils;
import org.primefaces.component.messages.Messages;
import org.primefaces.context.RequestContext;


@SessionScoped
@ManagedBean(name="datosBicicletasBean")
public class DatosBicicletasBean 
{
      // Para bicicletas
    private List<Bicicleta> bicicletasAdded;
    private long totalBicicletas = 0;
    private int cantBicicletas = 0;
    private String totalBicicletasFormato = "";
    
     public List<Bicicleta> getBicicletasAdded() {
        return this.bicicletasAdded;
    }
    public void setBicicletasAdded(List<Bicicleta> bicicletasAdded) {
        this.bicicletasAdded = bicicletasAdded;
    }
    public long getTotalBicicletas() {
        return this.totalBicicletas;
    }
    public void setTotalBicicletas(long totalBicicletas) {
        this.totalBicicletas = totalBicicletas;
        this.totalBicicletasFormato = Utilidades.formatearNumero(totalBicicletas);
    }
    public int getCantBicicletas() {
        return this.cantBicicletas;
    }
    public void setCantBicicletas(int cantBicicletas) {
        this.cantBicicletas = cantBicicletas;
    }
    public String getTotalBicicletasFormato() {
        return this.totalBicicletasFormato;
    }
    public void setTotalBicicletasFormato(String totalBicicletasFormato) {
        this.totalBicicletasFormato = totalBicicletasFormato;
    }
    
      public void onLoad()
    {  
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!fc.isPostback() )
        {
            System.out.println(" ON LOAD - NO POSTBACK");
            this.buscarMarcas();
            
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            
            List<Bicicleta> bicicletas = (List<Bicicleta>)context.getSessionMap().get("_PARAM_RETIRO-_PARAM_BICICLETAS_Bicicletas_SEL");
            
            if(bicicletas != null)
            {
                this.bicicletasAdded = bicicletas;
            }
            
        }
    }   
    
    private void cargarTotalesBicicletas()
    {
        if(this.bicicletasAdded != null && this.bicicletasAdded.size() > 0)
        {
            this.cantBicicletas = this.bicicletasAdded.size();
            this.setTotalBicicletas(this.bicicletasAdded.stream().map(b -> b.getPrecio()).mapToInt(Integer::intValue).sum());
        }
        else{
            this.cantBicicletas = 0;
            this.setTotalBicicletas(0);
        }
        RequestContext.getCurrentInstance().update("formGrillaBicicletas");
    }
    
    public void onImgRemoveBicicleta_click(Bicicleta bicicleta)
    {
        this.bicicletasAdded.remove(bicicleta);
        cargarTotalesBicicletas();
        RequestContext.getCurrentInstance().update("formGrillaBicicletas");
        
    }
    
    public void onBtnSiguiente_Click()
    {
        if(this.bicicletasAdded == null || this.bicicletasAdded.size() <=0)
        {
            String errorMsg = "Debe seleccionar al menos 1 bicicleta para realizar el arrindo";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMsg, errorMsg);
            FacesContext.getCurrentInstance().addMessage("formGrillaBicicletas:msgBicicletas", msg);
        }else{
        
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.getSessionMap().put("_PARAM_BICICLETAS_Bicicletas_SEL", this.bicicletasAdded);   
            
            FacesContext facesContext = FacesContext.getCurrentInstance();        
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/appWeb/arriendos/datosAccesorios.xhtml?faces-redirect=true");
        }
    }
    
    // Para popup de búsquedas
    private List<Marca> marcasBusq;
    private int marcaBusqSelected;
    List<Bicicleta> bicicletas;
    private String modeloBusq = "";

    public List<Marca> getMarcasBusq()
    {
        return this.marcasBusq;
    }
    public void setMarcasBusq(List<Marca> marcasBusq) 
    {
        this.marcasBusq = marcasBusq;
    }
    public int getMarcaBusqSelected() 
    {
        return this.marcaBusqSelected;
    }
    public void setMarcaBusqSelected(int marcaBusqSelected) 
    {
        this.marcaBusqSelected = marcaBusqSelected;
    }
    public List<Bicicleta> getBicicletas() 
    {
        return this.bicicletas;
    }
    public void setBicicletas(List<Bicicleta> bicicletas) 
    {
        this.bicicletas = bicicletas;
    }
    public String getModeloBusq() 
    {
        return this.modeloBusq;
    }
    public void setModeloBusq(String modeloBusq) 
    {
        this.modeloBusq = modeloBusq;
    }
    
    private void buscarMarcas()
    {
        GestionMarcas marcasGestion = new GestionMarcas();
        this.marcasBusq = marcasGestion.obtenerMarcas();
        this.marcasBusq.add(0, new Marca(0, "Todas"));
        this.marcaBusqSelected = 0;
    }
    private void buscarBicicletas()
    {
        String notFilters = "";
        if(this.bicicletasAdded != null && this.bicicletasAdded.size() > 0)
        {
            List<Integer> ids = this.bicicletasAdded.stream().map(Bicicleta::getIdBicicleta).collect(Collectors.toList());
            notFilters = StringUtils.join(ids, ",");
        }
        
        GestionBicicletas bicicletasGestion = new GestionBicicletas();
        this.bicicletas = bicicletasGestion.obtenerBicicletasNot(notFilters);
    }
    
    public void onBtnBuscar_Click()
    {
        buscarBicicletas();
        RequestContext.getCurrentInstance().execute("PF('dlgBusquedaBicicletas').initPosition();PF('dlgBusquedaBicicletas').show()");
        RequestContext.getCurrentInstance().update("formBusquedaBicicletas");
    }
    
    public void onBtnAceptar_Click()
    {
        List<Bicicleta> bicicletasSelected = this.bicicletas.stream().filter(f -> f.isSelectedAux()).collect(Collectors.toList());
        
        if(bicicletasSelected != null && bicicletasSelected.size() > 0 )
        {
            this.bicicletasAdded =  this.bicicletasAdded == null ? new ArrayList<>():  this.bicicletasAdded;
            this.bicicletasAdded.addAll(bicicletasSelected);
            this.cargarTotalesBicicletas();
        }
        RequestContext.getCurrentInstance().execute("PF('dlgBusquedaBicicletas').hide()");
        RequestContext.getCurrentInstance().update("formBusquedaBicicletas");
        RequestContext.getCurrentInstance().update("formGrillaBicicletas");
    }
    
    
    public void onBtnAbrirPopupBusqueda()
    {
        this.buscarBicicletas();
        RequestContext.getCurrentInstance().execute("PF('dlgBusquedaBicicletas').initPosition();PF('dlgBusquedaBicicletas').show()");
        RequestContext.getCurrentInstance().update("formBusquedaBicicletas");
        
    }
}
