package com.arriendo.modelos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TipoBicicleta  implements java.io.Serializable {


     private int idTipoBicicleta;
     private String descripcion;
     private Date fechaRegistro;
     private Byte estadoSincr;

    public TipoBicicleta() {
    }

	
    public TipoBicicleta(int idTipoBicicleta, String descripcion) {
        this.idTipoBicicleta = idTipoBicicleta;
        this.descripcion = descripcion;
    }
    public TipoBicicleta(int idTipoBicicleta, String descripcion, Date fechaRegistro, Byte estadoSincr) {
       this.idTipoBicicleta = idTipoBicicleta;
       this.descripcion = descripcion;
       this.fechaRegistro = fechaRegistro;
       this.estadoSincr = estadoSincr;
    }
   
    public int getIdTipoBicicleta() {
        return this.idTipoBicicleta;
    }
    
    public void setIdTipoBicicleta(int idTipoBicicleta) {
        this.idTipoBicicleta = idTipoBicicleta;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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


