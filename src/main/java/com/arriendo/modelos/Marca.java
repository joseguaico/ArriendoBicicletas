package com.arriendo.modelos;
// Generated 20-11-2017 14:02:58 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Marca generated by hbm2java
 */
public class Marca  implements java.io.Serializable {


     private int idMarca;
     private String descripcion;
     private Date fechaRegistro;
     private Byte estadoSincr;
     private Set bicicletas = new HashSet(0);

    public Marca() {
    }

	
    public Marca(int idMarca, String descripcion) {
        this.idMarca = idMarca;
        this.descripcion = descripcion;
    }
    public Marca(int idMarca, String descripcion, Date fechaRegistro, Byte estadoSincr, Set bicicletas) {
       this.idMarca = idMarca;
       this.descripcion = descripcion;
       this.fechaRegistro = fechaRegistro;
       this.estadoSincr = estadoSincr;
       this.bicicletas = bicicletas;
    }
   
    public int getIdMarca() {
        return this.idMarca;
    }
    
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
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


