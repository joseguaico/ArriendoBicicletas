package com.arriendos.gestores;

import com.arriendo.modelos.Cliente;
import com.arriendo.utilidades.MyHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class GestionClientes 
{
     public List<Cliente> obtenerClientes(String rut, String dv, String nombres, String apellidos)
    {
        Session session = null;
        List<Cliente> clientes = null;
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();   
            
            Query query = session.createQuery("FROM " + Cliente.class.getName() + " c "
                           + "WHERE str(c.rutCliente) LIKE :RUT "
                           + "AND c.dv = Case When :DV = '' Then c.dv else :DV End "
                           + "AND c.nombres LIKE :NOMBRES "
                           + "AND c.apellidos LIKE :APELLIDOS "
                           + " ORDER BY c.apellidos ASC"
            );
            query.setParameter("RUT", "%" + rut + "%");
            query.setParameter("DV", dv);
            query.setParameter("NOMBRES", "%" + nombres + "%");
            query.setParameter("APELLIDOS", "%" + apellidos + "%");
            clientes = query.list();

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
        return clientes;
    }
    
}
