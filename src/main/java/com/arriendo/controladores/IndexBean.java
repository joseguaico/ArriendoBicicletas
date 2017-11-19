package com.arriendo.controladores;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="indexBean")
public class IndexBean implements Serializable
{
    @PostConstruct
    public void onInit()
    {
    }
}
