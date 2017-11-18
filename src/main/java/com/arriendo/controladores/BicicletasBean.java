package com.arriendo.controladores;

import com.arriendo.modelos.Bicicleta;
import com.arriendo.modelos.Marca;
import com.arriendos.gestores.GestionBicicletas;
import com.arriendos.gestores.GestionMarcas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name="bicicletasBean")
public class BicicletasBean implements Serializable
{
    private List<Marca> marcasBusq;
    private int marcaBusqSelected;
    List<Bicicleta> bicicletas;
    private String modeloBusq = "";

    public List<Marca> getMarcasBusq()
    {
        return this.marcasBusq;
    }
    public void setMarcasBusq(List<Marca> marcasBusq) 
    {
        this.marcasBusq = marcasBusq;
    }
    public int getMarcaBusqSelected() 
    {
        return this.marcaBusqSelected;
    }
    public void setMarcaBusqSelected(int marcaBusqSelected) 
    {
        this.marcaBusqSelected = marcaBusqSelected;
    }
    public List<Bicicleta> getBicicletas() 
    {
        return this.bicicletas;
    }
    public void setBicicletas(List<Bicicleta> bicicletas) 
    {
        this.bicicletas = bicicletas;
    }
    public String getModeloBusq() 
    {
        return this.modeloBusq;
    }
    public void setModeloBusq(String modeloBusq) 
    {
        this.modeloBusq = modeloBusq;
    }
    
    @PostConstruct
    private void init()
    {
        this.buscarMarcas();
        this.buscarBicicletas();
    }
    
    private void buscarMarcas()
    {
        GestionMarcas marcasGestion = new GestionMarcas();
        this.marcasBusq = marcasGestion.obtenerMarcas();
        this.marcasBusq.add(0, new Marca(0, "Todas"));
        this.marcaBusqSelected = 0;
    }
    private void buscarBicicletas()
    {
         GestionBicicletas bicicletasGestion = new GestionBicicletas();
         this.bicicletas = bicicletasGestion.obtenerBicicletas(this.marcaBusqSelected, this.modeloBusq);
    }
    
    public void onBtnBuscar_Click()
    {
        buscarBicicletas();
        RequestContext.getCurrentInstance().update("formGrilla:panelGrilla");
    }
}
