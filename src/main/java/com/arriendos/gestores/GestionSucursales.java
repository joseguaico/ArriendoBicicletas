package com.arriendos.gestores;

import com.arriendo.modelos.Sucursal;
import com.arriendo.utilidades.MyHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class GestionSucursales 
{
    public List<Sucursal> obtenerSucursales()
    {
        Session session = null;
        List<Sucursal> tipos = null;
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();   
            
            Query query = session.createQuery("FROM " + Sucursal.class.getName() + " s "
                           + " ORDER BY s.descripcionSucursal ASC "
            );
            tipos = query.list();
          
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
        return tipos;
    }
}
