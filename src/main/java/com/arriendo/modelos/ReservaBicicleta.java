package com.arriendo.modelos;
// Generated 20-11-2017 14:02:58 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ReservaBicicleta generated by hbm2java
 */
public class ReservaBicicleta  implements java.io.Serializable {


     private ReservaBicicletaId id;
     private Bicicleta bicicleta;
     private Reserva reserva;
     private Date fechaRegistro;
     private Byte estadoSincr;

    public ReservaBicicleta() {
    }

	
    public ReservaBicicleta(ReservaBicicletaId id, Bicicleta bicicleta, Reserva reserva) {
        this.id = id;
        this.bicicleta = bicicleta;
        this.reserva = reserva;
    }
    public ReservaBicicleta(ReservaBicicletaId id, Bicicleta bicicleta, Reserva reserva, Date fechaRegistro, Byte estadoSincr) {
       this.id = id;
       this.bicicleta = bicicleta;
       this.reserva = reserva;
       this.fechaRegistro = fechaRegistro;
       this.estadoSincr = estadoSincr;
    }
   
    public ReservaBicicletaId getId() {
        return this.id;
    }
    
    public void setId(ReservaBicicletaId id) {
        this.id = id;
    }
    public Bicicleta getBicicleta() {
        return this.bicicleta;
    }
    
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
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
    public Byte getEstadoSincr() {
        return this.estadoSincr;
    }
    
    public void setEstadoSincr(Byte estadoSincr) {
        this.estadoSincr = estadoSincr;
    }




}


