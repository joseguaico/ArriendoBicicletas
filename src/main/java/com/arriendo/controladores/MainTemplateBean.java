package com.arriendo.controladores;

import com.arriendo.utilidades.ValoresAuxiliares;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name="mainTemplateBean")
public class MainTemplateBean implements Serializable
{
    private String usuarioActual = "";
    private String rol = "";
    private String ultimoAcceso = "";
    
    // Get/Set...
    public String getUsuarioActual() 
    {
        return this.usuarioActual;
    }
    public void setUsuarioActual(String usuarioActual) 
    {
        this.usuarioActual = usuarioActual;
    }
    public String getRol() 
    {
        return this.rol;
    }
    public void setRol(String rol) 
    {
        this.rol = rol;
    }
    public String getUltimoAcceso() 
    {
        return this.ultimoAcceso;
    }
    public void setUltimoAcceso(String ultimoAcceso) 
    {
        this.ultimoAcceso = ultimoAcceso;
    }
    
    
    @PostConstruct
    public void onInit()
    {
        this.usuarioActual = "Jose Guaico astorga";
        this.rol = "Funcionario de despacho";
        this.ultimoAcceso = "Domingo, 12 de noviembre de 2017 a las 23:02";
    }
    
    
}
