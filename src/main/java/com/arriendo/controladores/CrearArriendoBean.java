package com.arriendo.controladores;

import com.arriendo.modelos.Cliente;
import com.arriendo.modelos.Sucursal;
import com.arriendo.utilidades.ValoresAuxiliares;
import com.arriendos.gestores.GestionClientes;
import com.arriendos.gestores.GestionSucursales;
import java.io.Serializable;
import java.time.LocalTime;
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
    
     // Para agregar/editar Cliente
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
    
    // Para info de retiro y devolución
    private List<Sucursal> sucursalesRetiro;
    private Date fechaRetiro;
    private LocalTime horaRetiro;
    private int sucursalRetiroSelect;
    private List<Sucursal> sucursalesDevolucion;
    private int sucursalDevolucionSelect; 
    private LocalTime horaDevolucion;
       private Date fechaDevolucion;
    

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
    
    

    @PostConstruct
    private void onInit()
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        this.clienteSel = (Cliente)context.getSessionMap().get("_PARAM_CLIENTE_SEL");
        
        cargarSucursales();
    }
    
    private void cargarSucursales()
    {
        GestionSucursales sucursalesGestion = new GestionSucursales();
        this.sucursalesRetiro = sucursalesGestion.obtenerSucursales();
        this.sucursalesDevolucion = sucursalesGestion.obtenerSucursales();
    }
    
}
