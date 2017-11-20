package com.arriendo.controladores;

import com.arriendo.modelos.Cliente;
import com.arriendos.gestores.GestionClientes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name="clientesBean")
public class ClientesBean implements Serializable
{
     // Para Busqueda
    private String rutBusq = "";
    private String dvBusq = "";
    private String nombresBusq = "";
    private String apellidosBusq = "";
    
    private List<Cliente> clientes;
    private Cliente clienteSel;
    
    public String getRutBusq() {
        return (this.rutBusq != null ? this.rutBusq : "");
    }
    public void setRutBusq(String rut) {
        this.rutBusq = rut;
    }
    public String getDvBusq() {
        return (this.dvBusq != null ? this.dvBusq : "");
    }
    public void setDvBusq(String dv) {
        this.dvBusq = dv;
    }
    public String getNombresBusq() {
        return (this.nombresBusq != null? this.nombresBusq : "");
    }
    public void setNombresBusq(String nombres) {
        this.nombresBusq = nombres;
    }
    public String getApellidosBusq() {
        return (this.apellidosBusq != null ? this.apellidosBusq : "");
    }
    public void setApellidosBusq(String apellidos) {
        this.apellidosBusq = apellidos;
    }    
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    public Cliente getClienteSel() {
        return clienteSel;
    }
    public void setClienteSel(Cliente clienteSel) {
        this.clienteSel = clienteSel;
    }
    
    
    public void onImgAgregarArriendo_click(Cliente cliente)
    {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.getSessionMap().put("_PARAM_CLIENTE_SEL", cliente);        
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/appWeb/arriendos/datosCliente.xhtml?faces-redirect=true");
    }
    
    public void onLoad()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!fc.isPostback() )
        {
            this.buscarClientes();
        }
    }
    
    public void onBtnBuscarClick()
    {
        buscarClientes();
        RequestContext.getCurrentInstance().update("formGrilla:dtPrincipal");
    }
    
    private void buscarClientes()
    {
        GestionClientes clientesGestion = new GestionClientes();
        this.clientes = clientesGestion.obtenerClientes(this.getRutBusq(), this.getDvBusq(), this.getNombresBusq(), this.getApellidosBusq());
    }
 
}
