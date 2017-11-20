package com.arriendo.controladores.arriendos;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@SessionScoped
@ManagedBean(name="datosAccesoriosBean")
public class DatosAccesoriosBean implements Serializable
{
    
    public void onBtnSiguiente_Click()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/appWeb/arriendos/datosSeguros.xhtml?faces-redirect=true");
    }
     public void onBtnPrevio_Click()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/appWeb/arriendos/datosBicicletas.xhtml?faces-redirect=true");
    }
}
