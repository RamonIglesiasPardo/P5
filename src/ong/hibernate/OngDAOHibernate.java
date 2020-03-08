package ong.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;



public class OngDAOHibernate  implements DAOHibernate{
    public void agregarPersona(personalNacional Persona) {

        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.save(Persona);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    public int getLastId(String objectiveTable) {
        int id= 0;

        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            String sql  = "SELECT MAX(id) FROM "+objectiveTable;
            Query query = session.createQuery(sql);
            id = (int) query.uniqueResult();

        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return id;
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

    public void agregarPersonaInternacional(PersonalInternacional Persona) {

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
        }
    }
    public List<PersonalInternacional> mostrarPersonasInternacional() {
        List<PersonalInternacional> Personas = new ArrayList<PersonalInternacional>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Personas = session.createQuery("from PersonalInternacional").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

        return Personas;
    }
    public void eliminarPersonaInternacional(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            PersonalInternacional persona = (PersonalInternacional) session.load(PersonalInternacional.class, new Integer(id));
            session.delete(persona);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void actualizarPersonaInternacional(PersonalInternacional Persona) {
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

    public PersonalInternacional mostrarPersonaInternacional(int id) {
        PersonalInternacional Persona = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from PersonalInternacional where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            Persona = (PersonalInternacional) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return Persona;
    }

    public static String getNumberOfElements(String objectiveTable) {
        String numElements = null;

        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            String sql  = "SELECT COUNT(id) FROM " + objectiveTable;
            Query query = session.createQuery(sql);
            numElements = query.uniqueResult().toString();

        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return numElements;
    }

}