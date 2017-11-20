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
    
    public Cliente obtenerCliente(String rut, String dv)
    {
        Session session = null;
        Cliente cliente = null;
        
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();   
            
            Query query = session.createQuery("FROM " + Cliente.class.getName() + " c "
                           + "WHERE str(c.rutCliente) LIKE :RUT "
                           + "AND str(c.dv) = :DV "
            );
            query.setParameter("RUT", "%" + rut + "%");
            query.setParameter("DV", dv);
            List<Cliente> clientes = query.list();
            
            if (clientes != null && clientes.size() > 0)
            {
                cliente = clientes.get(0);
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
        return cliente;
    }
    
    public boolean insertCliente(Cliente cliente)
    {
        Session session = null;
        boolean procesoOk = false;
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();              
            session.beginTransaction();
            session.save(cliente);
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
    
    public boolean updateCliente(Cliente cliente)
    {
        Session session = null;
        boolean procesoOk = false;
        try
        {
            session = MyHibernateUtil.getSessionFactory().openSession();              
            session.beginTransaction();
            session.update(cliente);
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
    
    public boolean insertOrUpdate(Cliente cliente)
    {
        boolean procesoOk;
        if(this.obtenerCliente(Integer.toString(cliente.getRutCliente()), Character.toString(cliente.getDv())) != null)
        {
            procesoOk = this.updateCliente(cliente);
        }else{
            procesoOk = this.insertCliente(cliente);
        }
        return procesoOk;
    }
}
