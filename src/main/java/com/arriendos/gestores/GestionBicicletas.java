package com.arriendos.gestores;

import com.arriendo.modelos.Bicicleta;
import com.arriendo.modelos.EstadoBicicleta;
import com.arriendo.modelos.Marca;
import com.arriendo.modelos.TipoBicicleta;
import com.arriendo.utilidades.MyHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class GestionBicicletas 
{
    public List<Bicicleta> obtenerBicicletas(int marca, String modelo)
    {
        Session session = null;
        List<Bicicleta> bicicletas = null;
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();   
            
            Query query = session.createQuery("FROM " + Bicicleta.class.getName() + " b "
                        + " JOIN b.marca m " 
                        + " JOIN b.tipoBicicleta t " 
                        + " JOIN b.estadoBicicleta e"
                    + " WHERE m.idMarca = Case When :ID_MARCA = 0 then m.idMarca Else :ID_MARCA End "
                    + " AND b.modelo LIKE :MODELO "
                           + " ORDER BY m.descripcion ASC "
            );
            
            query.setParameter("ID_MARCA", marca);
            query.setParameter("MODELO", "%"+ modelo + "%");
            
            List<Object[]> tuples  = (List<Object[]>)query.list();
                        
            if(tuples != null && tuples.size() > 0)
            {
                bicicletas = new ArrayList<>();
                for(Object[] tuple : tuples) 
                {
                    Bicicleta bici = (Bicicleta)tuple[0];
                    bici.setMarca((Marca)tuple[1]);
                    bici.setTipoBicicleta((TipoBicicleta)tuple[2]);
                    bici.setEstadoBicicleta((EstadoBicicleta)tuple[3]);
                    bicicletas.add(bici);
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
        return bicicletas;
    }
    
    public List<Bicicleta> obtenerBicicletasNot(String listaNot)
    {
        Session session = null;
        List<Bicicleta> bicicletas = null;
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();   
            
            Query query = session.createQuery("FROM " + Bicicleta.class.getName() + " b "
                        + " JOIN b.marca m " 
                        + " JOIN b.tipoBicicleta t " 
                        + " WHERE str(b.idBicicleta) NOT IN (:NOT_LIST) "
                           + " ORDER BY m.descripcion ASC "
            );
            
            query.setParameter("NOT_LIST", listaNot);
            
            List<Object[]> tuples  = (List<Object[]>)query.list();
                        
            if(tuples != null && tuples.size() > 0)
            {
                bicicletas = new ArrayList<>();
                for(Object[] tuple : tuples) 
                {
                    Bicicleta bici = (Bicicleta)tuple[0];
                    bici.setMarca((Marca)tuple[1]);
                    bici.setTipoBicicleta((TipoBicicleta)tuple[2]);
                    bicicletas.add(bici);
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
        return bicicletas;
    }
}
