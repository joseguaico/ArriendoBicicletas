package com.arriendo.modelos;

import java.io.Serializable;

public class Marca  implements Serializable 
{
    private int idMarca;
    private String descripcion;

    public Marca()
    {
    }
    public Marca(int idMarca, String descripcion) 
    {
        this.idMarca = idMarca;
        this.descripcion = descripcion;
    }
    public int getIdMarca() 
    {
        return this.idMarca;
    }
    public void setIdMarca(int idMarca) 
    {
        this.idMarca = idMarca;
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


