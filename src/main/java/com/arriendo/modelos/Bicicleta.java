package com.arriendo.modelos;

import com.arriendo.utilidades.Utilidades;
import java.util.Date;

public class Bicicleta  implements java.io.Serializable {


     private int idBicicleta;
     private EstadoBicicleta estadoBicicleta;
     private Marca marca;
     private TipoBicicleta tipoBicicleta;
     private String modelo;
     private Integer precio;
     private Date fechaRegistro;
     private Byte estadoSincr;

    public Bicicleta() {
    }

	
    public Bicicleta(int idBicicleta, EstadoBicicleta estadoBicicleta, Marca marca, TipoBicicleta tipoBicicleta) {
        this.idBicicleta = idBicicleta;
        this.estadoBicicleta = estadoBicicleta;
        this.marca = marca;
        this.tipoBicicleta = tipoBicicleta;
    }
    public Bicicleta(int idBicicleta, EstadoBicicleta estadoBicicleta, Marca marca, TipoBicicleta tipoBicicleta, String modelo, Integer precio, Date fechaRegistro, Byte estadoSincr) {
       this.idBicicleta = idBicicleta;
       this.estadoBicicleta = estadoBicicleta;
       this.marca = marca;
       this.tipoBicicleta = tipoBicicleta;
       this.modelo = modelo;
       this.precio = precio;
       this.fechaRegistro = fechaRegistro;
       this.estadoSincr = estadoSincr;
    }
   
    public int getIdBicicleta() {
        return this.idBicicleta;
    }
    
    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
    }
    public EstadoBicicleta getEstadoBicicleta() {
        return this.estadoBicicleta;
    }
    
    public void setEstadoBicicleta(EstadoBicicleta estadoBicicleta) {
        this.estadoBicicleta = estadoBicicleta;
    }
    public Marca getMarca() {
        return this.marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public TipoBicicleta getTipoBicicleta() {
        return this.tipoBicicleta;
    }
    
    public void setTipoBicicleta(TipoBicicleta tipoBicicleta) {
        this.tipoBicicleta = tipoBicicleta;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Integer getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Integer precio) {
        this.precio = precio;
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
    
    public String obtenerPrecioConFormato()
    {
        return Utilidades.formatearNumero((long)this.precio);
    }



}


