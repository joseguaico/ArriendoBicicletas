package com.arriendo.controladores.arriendos;

import com.arriendo.modelos.Bicicleta;
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
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name="resumenFinalizarBean")
public class ResumenFinalizarBean implements Serializable
{
    // Textos auxiliares
    private String textoCliente = "(No seleccionado)";
    private String textoRutCliente = "(No seleccionado)";
    private String textoSucOrigen = "(No seleccionado)";
    private String textoFechaOrigen = "(No seleccionado)";
    private String textoSucDestino = "(No seleccionado)";
    private String textoFechaDestino = "(No seleccionado)";
    private String textoBicicletasCantiad = "0 bicicletas";
    private String textoBicicletasTotal = "$ 0";

    public String getTextoCliente() {
        return textoCliente;
    }
    public void setTextoCliente(String textoCliente) {
        this.textoCliente = textoCliente;
    }
    public String getTextoRutCliente() {
        return textoRutCliente;
    }
    public void setTextoRutCliente(String textoRutCliente) {
        this.textoRutCliente = textoRutCliente;
    }
    public String getTextoSucOrigen() {
        return textoSucOrigen;
    }
    public void setTextoSucOrigen(String textoSucOrigen) {
        this.textoSucOrigen = textoSucOrigen;
    }
    public String getTextoFechaOrigen() {
        return textoFechaOrigen;
    }
    public void setTextoFechaOrigen(String textoFechaOrigen) {
        this.textoFechaOrigen = textoFechaOrigen;
    }
    public String getTextoSucDestino() {
        return textoSucDestino;
    }
    public void setTextoSucDestino(String textoSucDestino) {
        this.textoSucDestino = textoSucDestino;
    }
    public String getTextoFechaDestino() {
        return textoFechaDestino;
    }
    public void setTextoFechaDestino(String textoFechaDestino) {
        this.textoFechaDestino = textoFechaDestino;
    }
    public String getTextoBicicletasCantiad() {
        return textoBicicletasCantiad;
    }
    public void setTextoBicicletasCantiad(String textoBicicletasCantiad) {
        this.textoBicicletasCantiad = textoBicicletasCantiad;
    }
    public String getTextoBicicletasTotal() {
        return textoBicicletasTotal;
    }
    public void setTextoBicicletasTotal(String textoBicicletasTotal) {
        this.textoBicicletasTotal = textoBicicletasTotal;
    }
    
    // Para info del cliente
    private Cliente clienteSel;
    
    // Para info de retiro y devolución
    private Sucursal sucursalRetiro;
    private Date fechaRetiro;
    private LocalTime horaRetiro;
    private Sucursal sucursalDevolucion;
    private LocalTime horaDevolucion;
    private Date fechaDevolucion;

    // Para bicicletas
    private List<Bicicleta> bicicletasAdded;
    private long totalBicicletas = 0;
    private int cantBicicletas = 0;
    private String totalBicicletasFormato = "";
    
    public Cliente getClienteSel() {
        return clienteSel;
    }
    public void setClienteSel(Cliente clienteSel) {
        this.clienteSel = clienteSel;
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
            
            cargarDatosCliente();
            cargarDatosOrigenDestino();
            cargarDatosBicicletas();
        }
    }    
       
    private void cargarDatosOrigenDestino()
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            
        this.sucursalRetiro = (Sucursal)context.getSessionMap().get("_PARAM_RETIRO-DEV_Sucursal_desde");
        if(this.sucursalRetiro!= null)
        {
            this.textoSucOrigen = this.sucursalRetiro.getDescripcionSucursal();
        }

        this.sucursalDevolucion = (Sucursal)context.getSessionMap().get("_PARAM_RETIRO-DEV_Sucursal_hasta");
        if(this.sucursalDevolucion != null)
        {
            this.textoSucDestino = this.sucursalDevolucion.getDescripcionSucursal();
        }
        
        this.fechaRetiro = (Date)context.getSessionMap().get("_PARAM_RETIRO-DEV_fecha_desde");
        this.fechaDevolucion = (Date)context.getSessionMap().get("_PARAM_RETIRO-DEV_fecha_hasta");
        this.horaRetiro = (LocalTime)context.getSessionMap().get("_PARAM_RETIRO-DEV_hora_desde");
        this.horaDevolucion = (LocalTime)context.getSessionMap().get("_PARAM_RETIRO-DEV_hora_hasta");
        
        if(this.fechaRetiro != null && this.horaRetiro != null)
        {
            this.textoFechaOrigen = Utilidades.formatearFecha(this.fechaRetiro) + " a las  " + Utilidades.formatearHora(this.horaRetiro);
        }
        if(this.fechaDevolucion != null && this.horaDevolucion != null)
        {
            this.textoFechaDestino = Utilidades.formatearFecha(this.fechaDevolucion) + " a las  " + Utilidades.formatearHora(this.horaDevolucion);
        }
        

        
    }
    private void cargarDatosCliente()
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        Cliente cliente = (Cliente)context.getSessionMap().get("_PARAM_CLIENTE_SEL");

        if(cliente == null)
        {
            this.clienteSel = null;
        }else{
            this.clienteSel = cliente;
            
            this.textoCliente = this.clienteSel.getNombres() + " " + this.clienteSel.getApellidos();
            this.textoRutCliente = Utilidades.formatearNumero((long)this.clienteSel.getRutCliente()) + "-" + this.clienteSel.getDv();
            
        }
    }
    private void cargarDatosBicicletas()
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            
        List<Bicicleta> bicicletas = (List<Bicicleta>)context.getSessionMap().get("_PARAM_BICICLETAS_Bicicletas_SEL");

        if(bicicletas != null)
        {
            this.bicicletasAdded = bicicletas;
        }
        cargarTotalesBicicletas();
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
    
    
}
