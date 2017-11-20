/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arriendos.gestores;

import com.arriendo.modelos.Bicicleta;
import com.arriendo.modelos.Cliente;
import com.arriendo.modelos.EstadoBicicleta;
import com.arriendo.modelos.Reserva;
import com.arriendo.modelos.ReservaBicicleta;
import com.arriendo.utilidades.MyHibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class GestionReservas 
{

    public List<Reserva> obtenerReservas(){
        Session session = null;
        List<Reserva> reservas = null;
        
        try{
            session = MyHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM "+Reserva.class.getName()+" r where estado = 1 order by r.fechaRetiro DESC");
            
            List<Object[]> tuples  = (List<Object[]>)query.list();
            
            if(tuples != null && tuples.size() > 0)
            {
                reservas = new ArrayList<>();
                //for(Object[] tuple : tuples) 
                 Iterator itr = tuples.iterator();
                 while(itr.hasNext())
                {
                    Reserva r1 = (Reserva)itr.next();
                    reservas.add(r1);
                }
            } 
        
        }catch(HibernateException e){
            System.out.println(" --  ERROR: " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(" -- ERROR: " + e.getMessage());
        }        
        finally{
            if(session != null){
                session.close();
            }           
        }
        
        return reservas;
    }

     public boolean insertReserva(Reserva reserva, List<Bicicleta> bicicletas)
    {
        Session session = null;
        boolean procesoOk = false;
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();              
            session.beginTransaction();
            int idReserva = (int)session.save(reserva);
            reserva.setIdReserva(idReserva);
            
            for(Bicicleta b : bicicletas)
            {
                ReservaBicicleta rb = new ReservaBicicleta();
                rb.setBicicleta(b);
                rb.setReserva(reserva);
                rb.setFechaRegistro(new Date());
                session.save(rb);
            }
        
            for(Bicicleta b : bicicletas)
            {
                b.setEstadoBicicleta(new EstadoBicicleta(3,""));
                session.update(b);
            }
            
            session.getTransaction().commit();
            procesoOk = true;

        }catch(HibernateException e){
            System.out.println(" --  ERROR: " + e.getMessage());
            session.getTransaction().rollback();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
            System.out.println(" -- ERROR: " + e.getMessage());
        }        
        finally{
            if(session != null){
                session.close();
            }           
        }
        return procesoOk;
    }

}
