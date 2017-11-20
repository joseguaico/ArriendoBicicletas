package com.arriendo.controladores;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean(name="indexBean")
public class IndexBean implements Serializable
{
    @PostConstruct
    public void onInit()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
        session.setAttribute("_USUARIO", "JOSE");
        session.setAttribute("_NOMBRE", "sdasdasd");
        
    }
}
