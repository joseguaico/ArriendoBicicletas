package com.arriendo.controladores.arriendos;

import com.arriendo.modelos.Cliente;
import com.arriendo.modelos.Sucursal;
import com.arriendo.utilidades.Utilidades;
import com.arriendos.gestores.GestionClientes;
import com.arriendos.gestores.GestionSucursales;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.component.messages.Messages;

@SessionScoped
@ManagedBean(name="datosRetiroDevolucionBean")
public class DatosRetiroDevolucionBean 
{
     // Para info de retiro y devolución
    private List<Sucursal> sucursalesRetiro;
    private Date fechaRetiro;
    private LocalTime horaRetiro;
    private int sucursalRetiroSelect;
    private List<Sucursal> sucursalesDevolucion;
    private int sucursalDevolucionSelect; 
    private LocalTime horaDevolucion;
    private Date fechaDevolucion;
    
      public List<Sucursal> getSucursalesRetiro() {
        return this.sucursalesRetiro;
    }
    public void setSucursalesRetiro(List<Sucursal> sucursalesRetiro) {
        this.sucursalesRetiro = sucursalesRetiro;
    }
    public List<Sucursal> getSucursalesDevolucion() {
        return this.sucursalesDevolucion;
    }
    public void setSucursalesDevolucion(List<Sucursal> sucursalesDevolucion) {
        this.sucursalesDevolucion = sucursalesDevolucion;
    }
    public int getSucursalRetiroSelect() {
        return this.sucursalRetiroSelect;
    }
    public void setSucursalRetiroSelect(int sucursalRetiroSelect) {
        this.sucursalRetiroSelect = sucursalRetiroSelect;
    }
    public int getSucursalDevolucionSelect() {
        return this.sucursalDevolucionSelect;
    }
    public void setSucursalDevolucionSelect(int sucursalDevolucionSelect) {
        this.sucursalDevolucionSelect = sucursalDevolucionSelect;
    }
    public Date getFechaRetiro() {
        return this.fechaRetiro;
    }
    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }
    public Date getFechaDevolucion() {
        return this.fechaDevolucion;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public LocalTime getHoraRetiro() {
        return this.horaRetiro;
    }
    public void setHoraRetiro(LocalTime horaRetiro) {
        this.horaRetiro = horaRetiro;
    }
    public LocalTime getHoraDevolucion() {
        return this.horaDevolucion;
    }
    public void setHoraDevolucion(LocalTime horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }
    
    public void onLoad()
    {  
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!fc.isPostback() )
        {
            System.out.println(" ON LOAD - NO POSTBACK");
            cargarSucursales();
            
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            
            Sucursal sucursalDesde = (Sucursal)context.getSessionMap().get("_PARAM_RETIRO-DEV_Sucursal_desde");
            if(sucursalDesde != null)
            {
                this.sucursalRetiroSelect = sucursalDesde.getIdSucursal();
            }
            
            Sucursal sucursalHasta = (Sucursal)context.getSessionMap().get("_PARAM_RETIRO-DEV_Sucursal_hasta");
            if(sucursalHasta != null)
            {
                this.sucursalDevolucionSelect = sucursalHasta.getIdSucursal();
            }
            this.fechaRetiro = (Date)context.getSessionMap().get("_PARAM_RETIRO-DEV_fecha_desde");
            this.fechaDevolucion = (Date)context.getSessionMap().get("_PARAM_RETIRO-DEV_fecha_hasta");

            this.horaRetiro = (LocalTime)context.getSessionMap().get("_PARAM_RETIRO-DEV_hora_desde");
            this.horaDevolucion = (LocalTime)context.getSessionMap().get("_PARAM_RETIRO-DEV_hora_hasta");
        }
    }    
    
    private void cargarSucursales()
    {
        GestionSucursales sucursalesGestion = new GestionSucursales();
        this.sucursalesRetiro = sucursalesGestion.obtenerSucursales();
        this.sucursalesDevolucion = sucursalesGestion.obtenerSucursales();
    }
    
    public boolean validarDatosRetiroDevolucion() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent component = context.getViewRoot().findComponent("formDatosRetiroDevolucion");
        UIInput ddlSucursalRetiro = (UIInput) component.findComponent("ddlSucursalRetiro");
        UIInput calFechaRetiro = (UIInput) component.findComponent("calFechaRetiro");
        UIInput timeHoraRetiro = (UIInput) component.findComponent("timeHoraRetiro");
        UIInput ddlSucursalDevolucion = (UIInput) component.findComponent("ddlSucursalDevolucion");
        UIInput calFechaDevolucion = (UIInput) component.findComponent("calFechaDevolucion");
        UIInput timeHoraDevolucion = (UIInput) component.findComponent("timeHoraDevolucion");
        Messages messages = (Messages)component.findComponent("msgDatosRetiroDevolucion");
        messages.setStyle("");  
       
        boolean isValid = true;
        String errorMsg = "";
        
        ddlSucursalRetiro.setValid(this.sucursalDevolucionSelect > 0);
        calFechaRetiro.setValid(this.fechaRetiro != null);
        timeHoraRetiro.setValid(this.horaRetiro != null);
        ddlSucursalDevolucion.setValid(this.sucursalDevolucionSelect > 0);
        calFechaDevolucion.setValid(this.fechaDevolucion != null);
        timeHoraDevolucion.setValid(this.horaDevolucion != null);
        

        if (  this.sucursalDevolucionSelect <= 0 || this.fechaRetiro == null
          || this.horaRetiro == null || this.sucursalDevolucionSelect <= 0
           || this.fechaDevolucion == null || this.horaDevolucion == null
                ) 
        {
            isValid = false;
            errorMsg = " * Campos obligatorios";
        }
        
        // Valida Fecha retiro
        if (this.fechaRetiro != null)
        {
            String fechaRet = Utilidades.formatearFecha(this.getFechaRetiro());

            if (!Utilidades.validarFechaConFormato(fechaRet))
            {
                isValid = false;
                errorMsg += "<br />Fecha de retiro. no es válida";
                calFechaRetiro.setValid(false);
            }
        }
         // Valida hora retiro
        if (this.horaRetiro != null)
        {
            String horaRet = Utilidades.formatearHora(this.getHoraRetiro());

            if (!Utilidades.validarHoraConFormato(horaRet))
            {
                isValid = false;
                errorMsg += "<br />La hora de retiro no es válida";
                timeHoraRetiro.setValid(false);
            }
        }
        // Valida Fecha devolucion
        if (this.fechaDevolucion != null)
        {
            String fechaDev = Utilidades.formatearFecha(this.getFechaDevolucion());

            if (!Utilidades.validarFechaConFormato(fechaDev))
            {
                isValid = false;
                errorMsg += "<br />Fecha de devolución no es válida";
                calFechaDevolucion.setValid(false);
            }
        }
         // Valida hora devolucion
        if (this.horaDevolucion != null)
        {
            String horaDev = Utilidades.formatearHora(this.getHoraRetiro());

            if (!Utilidades.validarHoraConFormato(horaDev))
            {
                isValid = false;
                errorMsg += "<br />La hora de retiro no es válida";
                timeHoraDevolucion.setValid(false);
            }
        }
     
        if (this.fechaRetiro != null && this.horaRetiro != null && this.fechaDevolucion != null && this.horaDevolucion != null && isValid)
        {
            String fechaRet = Utilidades.formatearFecha(this.getFechaRetiro());
            String horaRet = Utilidades.formatearHora(this.getHoraRetiro());
            String fechaDev = Utilidades.formatearFecha(this.getFechaDevolucion());
            String horaDev = Utilidades.formatearHora(this.getHoraDevolucion());
            
            Date fechaDesdeFull = Utilidades.stringToDate(fechaRet,horaRet);
            Date fechaHastaFull = Utilidades.stringToDate(fechaDev,horaDev);
            
            if(fechaHastaFull.before(fechaDesdeFull) || fechaDesdeFull.equals(fechaHastaFull))
            {
                isValid = false;
                errorMsg += "<br />La fecha de devolución debe ser posterior a la fecha de retiro";
                calFechaDevolucion.setValid(false);
            }
        }
        
        
        if(isValid){
            //FacesMessage msg = new FacesMessage("OK", "OK");
            //FacesContext.getCurrentInstance().addMessage("formDetalle:msgAddCliente", msg);
            messages.setStyle("display:none");
        }else{
            
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMsg, errorMsg);
            FacesContext.getCurrentInstance().addMessage("formDatosRetiroDevolucion:msgDatosRetiroDevolucion", msg);
        }      
        return isValid;
    }
    
     public Sucursal obtenerSucursalSeleccionada(int id)
    {
        return this.sucursalesRetiro.stream().filter(s -> s.getIdSucursal()== id).findFirst().orElse(null);
    }
    
    public void onBtnSiguiente_Click()
    {
        if(this.validarDatosRetiroDevolucion())
        { 
            Sucursal sucursalDesde = this.obtenerSucursalSeleccionada(this.sucursalRetiroSelect);
            Sucursal sucursalHasta = this.obtenerSucursalSeleccionada(this.sucursalDevolucionSelect);
            
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.getSessionMap().put("_PARAM_RETIRO-DEV_Sucursal_desde", sucursalDesde);   
            externalContext.getSessionMap().put("_PARAM_RETIRO-DEV_Sucursal_hasta", sucursalHasta);   
            externalContext.getSessionMap().put("_PARAM_RETIRO-DEV_fecha_desde", this.fechaRetiro);   
            externalContext.getSessionMap().put("_PARAM_RETIRO-DEV_fecha_hasta", this.fechaDevolucion);
            externalContext.getSessionMap().put("_PARAM_RETIRO-DEV_hora_desde", this.horaRetiro);   
            externalContext.getSessionMap().put("_PARAM_RETIRO-DEV_hora_hasta", this.horaDevolucion);
            
            FacesContext facesContext = FacesContext.getCurrentInstance();        
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/appWeb/arriendos/datosBicicletas.xhtml?faces-redirect=true");
            
        }
    }
    
}
