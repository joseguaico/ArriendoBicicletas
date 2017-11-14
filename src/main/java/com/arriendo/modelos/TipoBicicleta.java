package com.arriendo.modelos;

import java.io.Serializable;

public class TipoBicicleta  implements Serializable 
{
    private int idTipoBicicleta;
    private String descripcion;

    public TipoBicicleta() 
    {
    }
    public TipoBicicleta(int idTipoBicicleta, String descripcion) 
    {
        this.idTipoBicicleta = idTipoBicicleta;
        this.descripcion = descripcion;
    }
    public int getIdTipoBicicleta() 
    {
        return this.idTipoBicicleta;
    }
    public void setIdTipoBicicleta(int idTipoBicicleta) 
    {
        this.idTipoBicicleta = idTipoBicicleta;
    }
    public String getDescripcion() 
    {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
}


