package com.arriendo.controladores;

import com.arriendo.utilidades.ValoresAuxiliares;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name="arriendosBean")
public class ArriendosBean implements Serializable
{
    
    @PostConstruct
    public void onInit()
    {
    }
    
}
