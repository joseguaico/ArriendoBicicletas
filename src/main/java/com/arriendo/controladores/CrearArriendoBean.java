package com.arriendo.controladores;

import com.arriendo.modelos.Cliente;
import com.arriendo.utilidades.ValoresAuxiliares;
import com.arriendos.gestores.GestionClientes;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name="crearArriendoBean")
public class CrearArriendoBean 
{
    private Cliente clienteSel;
    
     // Para agregar/editar
    private String rut = "";
    private String dv = "";
    private String nombres = "";
    private String apellidos = "";
    private String telefonos = "";
    private String celular = "";
    private Date fechaNac;
    private String email = "";
    private String nacionalidad = "";
    //private List<EstadoCliente> estados;
    //private int estadoSel;
    

    public String getRut() {
        return this.rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getDv() {
        return this.dv;
    }
    public void setDv(String dv) {
        this.dv = dv;
    }
    public String getNombres() {
        return this.nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefonos() {
        return this.telefonos;
    }
    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }
    public String getCelular() {
        return this.celular;
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
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public Cliente getClienteSel() {
        return this.clienteSel;
    }
    public void setClienteSel(Cliente clienteSel) {
        this.clienteSel = clienteSel;
    }
    
    @PostConstruct
    private void onInit()
    {
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        this.clienteSel = (Cliente)context.getSessionMap().get("_PARAM_CLIENTE_SEL");
        
        
    }
    
}
