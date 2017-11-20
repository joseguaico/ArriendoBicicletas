package com.arriendo.modelos;
// Generated 20-11-2017 14:02:58 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Da�o generated by hbm2java
 */
public class Daño  implements java.io.Serializable {


     private int idDaño;
     private Reserva reserva;
     private Date fechaRegistro;
     private String observaciones;
     private int monto;

    public Daño() {
    }

    public Daño(int idDaño, Reserva reserva, Date fechaRegistro, String observaciones, int monto) {
       this.idDaño = idDaño;
       this.reserva = reserva;
       this.fechaRegistro = fechaRegistro;
       this.observaciones = observaciones;
       this.monto = monto;
    }
   
    public int getIdDaño() {
        return this.idDaño;
    }
    
    public void setIdDaño(int idDaño) {
        this.idDaño = idDaño;
    }
    public Reserva getReserva() {
        return this.reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }




}


