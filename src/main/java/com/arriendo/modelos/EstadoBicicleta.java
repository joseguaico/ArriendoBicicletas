package com.arriendo.modelos;
// Generated 20-11-2017 14:02:58 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * EstadoBicicleta generated by hbm2java
 */
public class EstadoBicicleta  implements java.io.Serializable {


     private int idEstado;
     private String descripcion;
     private Date fechaRegistro;
     private Byte estadoSincr;
     private Set bicicletas = new HashSet(0);

    public EstadoBicicleta() {
    }

	
    public EstadoBicicleta(int idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }
    public EstadoBicicleta(int idEstado, String descripcion, Date fechaRegistro, Byte estadoSincr, Set bicicletas) {
       this.idEstado = idEstado;
       this.descripcion = descripcion;
       this.fechaRegistro = fechaRegistro;
       this.estadoSincr = estadoSincr;
       this.bicicletas = bicicletas;
    }
   
    public int getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
    public Set getBicicletas() {
        return this.bicicletas;
    }
    
    public void setBicicletas(Set bicicletas) {
        this.bicicletas = bicicletas;
    }




}


