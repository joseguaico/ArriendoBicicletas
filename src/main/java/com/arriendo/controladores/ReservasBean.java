package com.arriendo.controladores;

import com.arriendo.modelos.Reserva;
import com.arriendo.utilidades.ValoresAuxiliares;
import com.arriendos.gestores.GestionReservas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name="reservasBean")
public class ReservasBean implements Serializable
{
    List<Reserva> reservas;

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    @PostConstruct
    public void onInit()
    {
        this.buscarReservas();
    }
    
    private void buscarReservas(){
        GestionReservas reservaGestion = new GestionReservas();
        reservas = reservaGestion.obtenerReservas();
    }

}
