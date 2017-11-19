package com.arriendo.controladores;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name="arriendosBean")
public class ArriendosBean implements Serializable
{
    
    @PostConstruct
    public void onInit()
    {
    }
    
    public void onBtnCrearNuevoSin_Click()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "/appWeb/arriendos/crearArriendo.xhtml?faces-redirect=true");
    }
    
}
