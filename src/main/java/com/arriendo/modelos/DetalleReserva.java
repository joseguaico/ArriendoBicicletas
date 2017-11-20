package com.arriendo.modelos;
// Generated 20-11-2017 14:02:58 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * DetalleReserva generated by hbm2java
 */
public class DetalleReserva  implements java.io.Serializable {


     private int idDetalle;
     private Reserva reserva;
     private Sucursal sucursal;
     private TipoDetalleReserva tipoDetalleReserva;
     private Date fechaRegistro;
     private String observacion;
     private Byte estadoSincr;

    public DetalleReserva() {
    }

	
    public DetalleReserva(int idDetalle, Reserva reserva, Sucursal sucursal, TipoDetalleReserva tipoDetalleReserva, Date fechaRegistro) {
        this.idDetalle = idDetalle;
        this.reserva = reserva;
        this.sucursal = sucursal;
        this.tipoDetalleReserva = tipoDetalleReserva;
        this.fechaRegistro = fechaRegistro;
    }
    public DetalleReserva(int idDetalle, Reserva reserva, Sucursal sucursal, TipoDetalleReserva tipoDetalleReserva, Date fechaRegistro, String observacion, Byte estadoSincr) {
       this.idDetalle = idDetalle;
       this.reserva = reserva;
       this.sucursal = sucursal;
       this.tipoDetalleReserva = tipoDetalleReserva;
       this.fechaRegistro = fechaRegistro;
       this.observacion = observacion;
       this.estadoSincr = estadoSincr;
    }
   
    public int getIdDetalle() {
        return this.idDetalle;
    }
    
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }
    public Reserva getReserva() {
        return this.reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public Sucursal getSucursal() {
        return this.sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    public TipoDetalleReserva getTipoDetalleReserva() {
        return this.tipoDetalleReserva;
    }
    
    public void setTipoDetalleReserva(TipoDetalleReserva tipoDetalleReserva) {
        this.tipoDetalleReserva = tipoDetalleReserva;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Byte getEstadoSincr() {
        return this.estadoSincr;
    }
    
    public void setEstadoSincr(Byte estadoSincr) {
        this.estadoSincr = estadoSincr;
    }




}


