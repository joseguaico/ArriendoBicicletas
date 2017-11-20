package com.arriendo.modelos;
// Generated 20-11-2017 14:02:58 by Hibernate Tools 4.3.1



/**
 * ReservaAccesoriosId generated by hbm2java
 */
public class ReservaAccesoriosId  implements java.io.Serializable {


     private int idReserva;
     private int idAccesorios;

    public ReservaAccesoriosId() {
    }

    public ReservaAccesoriosId(int idReserva, int idAccesorios) {
       this.idReserva = idReserva;
       this.idAccesorios = idAccesorios;
    }
   
    public int getIdReserva() {
        return this.idReserva;
    }
    
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public int getIdAccesorios() {
        return this.idAccesorios;
    }
    
    public void setIdAccesorios(int idAccesorios) {
        this.idAccesorios = idAccesorios;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ReservaAccesoriosId) ) return false;
		 ReservaAccesoriosId castOther = ( ReservaAccesoriosId ) other; 
         
		 return (this.getIdReserva()==castOther.getIdReserva())
 && (this.getIdAccesorios()==castOther.getIdAccesorios());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdReserva();
         result = 37 * result + this.getIdAccesorios();
         return result;
   }   


}

