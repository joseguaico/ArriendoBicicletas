package com.arriendo.modelos;

public class EstadoBicicleta  implements java.io.Serializable 
{
    private int idEstado;
    private String descripcion;

    public EstadoBicicleta() 
    {
    }
    public EstadoBicicleta(int idEstado, String descripcion) 
    {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }
    public int getIdEstado() 
    {
        return this.idEstado;
    }
    public void setIdEstado(int idEstado) 
    {
        this.idEstado = idEstado;
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


