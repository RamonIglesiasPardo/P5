package ong.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ong.entreculturas.Persona;



public class OngDAOHibernate  implements DAOHibernate{
    public void agregarPersona(Persona Persona) {

        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(Persona);

        try {
            trns = session.beginTransaction();
            session.save(Persona);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public List<Persona> mostrarPersonas() {
        List<Persona> Personas = new ArrayList<Persona>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Personas = session.createQuery("from Persona").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

        return Personas;
    }
    public void eliminarPersona(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Persona persona = (Persona) session.load(Persona.class, new Integer(id));
            session.delete(persona);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void actualizarPersona(Persona Persona) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(Persona);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public Persona mostrarPersona(int id) {
        Persona Persona = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Persona where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            Persona = (Persona) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return Persona;
    }
}