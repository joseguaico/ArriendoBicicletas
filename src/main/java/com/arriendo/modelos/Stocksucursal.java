package com.arriendo.modelos;
// Generated 20-11-2017 14:02:58 by Hibernate Tools 4.3.1



/**
 * Stocksucursal generated by hbm2java
 */
public class Stocksucursal  implements java.io.Serializable {


     private int idStock;
     private Sucursal sucursal;
     private int codigoBicicleta;

    public Stocksucursal() {
    }

    public Stocksucursal(int idStock, Sucursal sucursal, int codigoBicicleta) {
       this.idStock = idStock;
       this.sucursal = sucursal;
       this.codigoBicicleta = codigoBicicleta;
    }
   
    public int getIdStock() {
        return this.idStock;
    }
    
    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }
    public Sucursal getSucursal() {
        return this.sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    public int getCodigoBicicleta() {
        return this.codigoBicicleta;
    }
    
    public void setCodigoBicicleta(int codigoBicicleta) {
        this.codigoBicicleta = codigoBicicleta;
    }




}

