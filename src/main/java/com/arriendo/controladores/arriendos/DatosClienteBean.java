package com.arriendo.controladores.arriendos;

import com.arriendo.modelos.Cliente;
import com.arriendo.utilidades.Utilidades;
import com.arriendos.gestores.GestionClientes;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.component.messages.Messages;

@SessionScoped
@ManagedBean(name="datosClienteBean")
public class DatosClienteBean implements Serializable
{
    // Para agregar/editar Cliente
    private String rut = "";
    private String dv = "";
    private String nombres = "";
    private String apellidos = "";
    private String telefonos = "";
    private String celular = "";
    private Date fechaNac = null;
    private String email = "";
    private String nacionalidad = "";
    private String direccion = "";
    private boolean clienteNuevo = true;
     
    public String getRut() {
        return this.rut == null ? "": this.rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getDv() {
        return this.dv == null ? "" : this.dv;
    }
    public void setDv(String dv) {
        this.dv = dv;
    }
    public String getNombres() {
        return this.nombres == null ? "" : this.nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos == null ? "" : this.apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefonos() {
        return this.telefonos == null ? "" : this.telefonos;
    }
    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }
    public String getCelular() {
        return this.celular == null ? "" : this.celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public Date getFechaNac() {
        return this.fechaNac;
    }
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    public String getEmail() {
        return this.email == null ? "" : this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNacionalidad() {
        return this.nacionalidad == null ? "" : this.nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public boolean isClienteNuevo() {
        return this.clienteNuevo;
    }
    public void setClienteNuevo(boolean clienteNuevo) {
        this.clienteNuevo = clienteNuevo;
    }
    public String getDireccion() {
        return this.direccion == null ? "" : this.direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void onLoad()
    {  
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!fc.isPostback() )
        {
            System.out.println(" ON LOAD - NO POSTBACK");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            Cliente cliente = (Cliente)context.getSessionMap().get("_PARAM_CLIENTE_SEL");

            if(cliente == null)
            {
                //this.setClienteSel(new Cliente());
                this.clienteNuevo = true;
                cargarCliente();
            }else{
                this.clienteNuevo = false;
                cargarCliente(cliente);
            }
        }
    }
    private void cargarCliente()
    {
        this.rut = "";
        this.dv = "";
        this.nombres = "";
        this.apellidos = "";
        this.fechaNac = null;
        this.telefonos = "";
        this.email = "";
        this.direccion = "";
        this.nacionalidad = "";
    }
    private void cargarCliente(Cliente cliente)
    {
        this.rut = Integer.toString(cliente.getRutCliente());
        this.dv = Character.toString(cliente.getDv());
        this.nombres = cliente.getNombres();
        this.apellidos = cliente.getApellidos();
        this.fechaNac = cliente.getFechaNacimiento();
        this.telefonos = cliente.getTelefono();
        this.email = cliente.getEmail();
        this.direccion = cliente.getDireccion();
        this.nacionalidad = cliente.getNacionalidad();
    }
    private Cliente obtenerCliente()
    {
        Cliente cliente = new Cliente();
        cliente.setRutCliente(Integer.parseInt(this.rut.trim()));
        cliente.setDv(this.dv.trim().charAt(0));
        cliente.setNombres(this.nombres);
        cliente.setApellidos(this.apellidos);
        cliente.setFechaNacimiento(this.fechaNac);
        cliente.setTelefono(this.telefonos);
        cliente.setEmail(this.email);
        cliente.setDireccion(this.direccion);
        cliente.setNacionalidad(this.nacionalidad);
        cliente.setFechaRegistro(new Date());
        return cliente;        
    }
    
    
    public void onBtnSiguiente_Click()
    {
        if(this.validarDatosCliente())
        { 
            GestionClientes clientesGestion = new GestionClientes();
            boolean clienteOK = false;
            
            Cliente cliente = this.obtenerCliente();

            clienteOK = clientesGestion.insertOrUpdate(cliente);
            
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.getSessionMap().put("_PARAM_CLIENTE_SEL", cliente);        
            FacesContext facesContext = FacesContext.getCurrentInstance();        
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/appWeb/arriendos/datosRetiroDevolucion.xhtml?faces-redirect=true");
            
        }
    }
    public boolean validarDatosCliente() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent component = context.getViewRoot().findComponent("formInfoCliente");
        UIInput txtRut = (UIInput) component.findComponent("txtRut");
        UIInput txtDv = (UIInput) component.findComponent("txtDv");
        UIInput txtNombres = (UIInput) component.findComponent("txtNombres");
        UIInput txtApellidos = (UIInput) component.findComponent("txtApellidos");
        UIInput calFechaNac = (UIInput) component.findComponent("calFechaNac");
        UIInput txtFono = (UIInput) component.findComponent("txtFono");
        UIInput txtEmail = (UIInput) component.findComponent("txtEmail");
        UIInput txtNacionalidad = (UIInput) component.findComponent("txtNacionalidad");
        Messages messages = (Messages)component.findComponent("msgDatosCliente");
        messages.setStyle("");  
       
        boolean validarRut = true;
        boolean isValid = true;
        String errorMsg = "";
        
        if(this.clienteNuevo == true)
        {
            if (this.getRut().trim().isEmpty())
            {
                txtRut.setValid(false);
                isValid = false;
            }
            if (this.getDv().trim().isEmpty())
            {
                txtDv.setValid(false);
                isValid = false;
            }
        }
        txtNombres.setValid(!this.getNombres().trim().isEmpty());
        txtApellidos.setValid(!this.getApellidos().trim().isEmpty());
        calFechaNac.setValid(this.getFechaNac() == null ? false : true);
        txtFono.setValid(!this.getTelefonos().trim().isEmpty());
        txtEmail.setValid(!this.getEmail().trim().isEmpty());
        txtNacionalidad.setValid(!this.getNacionalidad().trim().isEmpty());
        
        
        
        if(validarRut == true && isValid == false)
        {
            errorMsg = " * Campos obligatorios";
        }

        if (  this.getNombres().trim().isEmpty() || this.getApellidos().trim().isEmpty()
          || this.getTelefonos().trim().isEmpty() || this.getEmail().trim().isEmpty()
           || this.getFechaNac()== null || this.getNacionalidad().trim().isEmpty()
                ) 
        {
            isValid = false;
            errorMsg = " * Campos obligatorios";
        }
        
        // Valida Rut
        if (validarRut)
        {
            if (!this.getRut().trim().isEmpty() && !this.getDv().trim().isEmpty())
            {
                int rut = Integer.parseInt(this.getRut().trim());
                char dv = this.getDv().toUpperCase().trim().charAt(0);

                if (!Utilidades.validarRut(rut, dv))
                {
                    isValid = false;
                    errorMsg += "<br />El rut ingresado es incorrecto";
                    txtRut.setValid(false);
                    txtDv.setValid(false);
                }
            }
        }
        
        // Valida Fecha nacimiento
        if (this.getFechaNac()!=null)
        {
            String fechaNac = Utilidades.formatearFecha(this.getFechaNac());

            if (!Utilidades.validarFechaConFormato(fechaNac))
            {
                isValid = false;
                errorMsg += "<br />Fecha Nac. no es válida";
                calFechaNac.setValid(false);
            }
        }
        // Valida Email
        if (!this.getEmail().trim().isEmpty())
        {
            String email = this.getEmail().trim();

            if (!Utilidades.validarEmail(email))
            {
                isValid = false;
                errorMsg += "<br />El email ingresado no es válido";
                txtEmail.setValid(false);
            }
        }
        
        if(isValid){
            //FacesMessage msg = new FacesMessage("OK", "OK");
            //FacesContext.getCurrentInstance().addMessage("formDetalle:msgAddCliente", msg);
            messages.setStyle("display:none");
        }else{
            
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMsg, errorMsg);
            FacesContext.getCurrentInstance().addMessage("formInfoCliente:msgDatosCliente", msg);
        }      
        return isValid;
    }
    
}

