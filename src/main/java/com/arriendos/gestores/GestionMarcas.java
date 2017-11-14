package com.arriendos.gestores;

import com.arriendo.modelos.Marca;
import com.arriendo.utilidades.MyHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class GestionMarcas 
{
    public List<Marca> obtenerMarcas()
    {
        Session session = null;
        List<Marca> tipos = null;
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();   
            
            Query query = session.createQuery("FROM " + Marca.class.getName() + " m "
                           + " ORDER BY m.descripcion ASC "
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
