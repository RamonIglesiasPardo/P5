package ong.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ong.hibernate.personalNacional;



public class OngDAOHibernate  implements DAOHibernate{
    public void agregarPersona(personalNacional Persona) {

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
    public List<personalNacional> mostrarPersonas() {
        List<personalNacional> Personas = new ArrayList<personalNacional>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Personas = session.createQuery("from personalNacional").list();
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
            personalNacional persona = (personalNacional) session.load(personalNacional.class, new Integer(id));
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

    public void actualizarPersona(personalNacional Persona) {
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

    public personalNacional mostrarPersona(int id) {
        personalNacional Persona = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from personalNacional where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            Persona = (personalNacional) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return Persona;
    }
}