package com.arriendo.modelos;

import com.arriendo.utilidades.Utilidades;
import java.io.Serializable;

public class Bicicleta  implements Serializable 
{
    private int idBicicleta;
    private EstadoBicicleta estadoBicicleta;
    private Marca marca;
    private TipoBicicleta tipoBicicleta;
    private String modelo;
    private Integer precio;

    public Bicicleta() {
    }

	
    public Bicicleta(int idBicicleta, EstadoBicicleta estadoBicicleta, Marca marca, TipoBicicleta tipoBicicleta) {
        this.idBicicleta = idBicicleta;
        this.estadoBicicleta = estadoBicicleta;
        this.marca = marca;
        this.tipoBicicleta = tipoBicicleta;
    }
    public Bicicleta(int idBicicleta, EstadoBicicleta estadoBicicleta, Marca marca, TipoBicicleta tipoBicicleta, String modelo, Integer precio) {
       this.idBicicleta = idBicicleta;
       this.estadoBicicleta = estadoBicicleta;
       this.marca = marca;
       this.tipoBicicleta = tipoBicicleta;
       this.modelo = modelo;
       this.precio = precio;
    }
   
    public int getIdBicicleta() 
    {
        return this.idBicicleta;
    }
    public void setIdBicicleta(int idBicicleta) 
    {
        this.idBicicleta = idBicicleta;
    }
    public EstadoBicicleta getEstadoBicicleta() 
    {
        return this.estadoBicicleta;
    }
    public void setEstadoBicicleta(EstadoBicicleta estadoBicicleta) 
    {
        this.estadoBicicleta = estadoBicicleta;
    }
    public Marca getMarca() 
    {
        return this.marca;
    }
    public void setMarca(Marca marca) 
    {
        this.marca = marca;
    }
    public TipoBicicleta getTipoBicicleta() 
    {
        return this.tipoBicicleta;
    }
    public void setTipoBicicleta(TipoBicicleta tipoBicicleta) 
    {
        this.tipoBicicleta = tipoBicicleta;
    }
    public String getModelo() 
    {
        return this.modelo;
    }
    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }
    public Integer getPrecio() 
    {
        return this.precio;
    }
    public void setPrecio(Integer precio) 
    {
        this.precio = precio;
    }
    public String obtenerPrecioConFormato()
    {
        return Utilidades.formatearNumero((double)this.precio);
    }
}


