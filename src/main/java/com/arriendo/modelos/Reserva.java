/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arriendo.modelos;

import java.util.Date;

/**
 *
 * @author mauro
 */
public class Reserva {
    private int id;
    private String idReserva;
    private int idBicicleta;
    private int rutCliente;
    private Date fechaSolicitud;
    private Date fechaRetiro;
    private int idSucursalRetiro;
    private Date fechaDevolucion;
    private int sucursalDevolucion;
    private int estado;

    public Reserva(){
    }
    
    public Reserva(int id,String codReserva, int idBicicleta, int rutCliente, Date fechaSolicitud, Date fechaRetiro, int idSucursalRetiro, Date fechaDevolucion, int sucursalDevolucion, int estado) {
        this.id = id;
        this.idReserva = codReserva;
        this.idBicicleta = idBicicleta;
        this.rutCliente = rutCliente;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRetiro = fechaRetiro;
        this.idSucursalRetiro = idSucursalRetiro;
        this.fechaDevolucion = fechaDevolucion;
        this.sucursalDevolucion = sucursalDevolucion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public int getIdSucursalRetiro() {
        return idSucursalRetiro;
    }

    public void setIdSucursalRetiro(int idSucursalRetiro) {
        this.idSucursalRetiro = idSucursalRetiro;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getSucursalDevolucion() {
        return sucursalDevolucion;
    }

    public void setSucursalDevolucion(int sucursalDevolucion) {
        this.sucursalDevolucion = sucursalDevolucion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
