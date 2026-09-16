package dao;

import basedatos.HibernateUtil;
import jakarta.persistence.NoResultException;
import model.Autor;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LibroDAO {
    private Session session;
    private Transaction transaction;

    public Libro getLibro(Libro libroInsert){

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.persist(libroInsert);

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        }finally {
            session.close();
        }
        return libroInsert;
    }

    public void getLibroPorISDN(String isdn){

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.find(Libro.class, isdn);

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        }finally {
            session.close();
        }
    }



    public Libro getPorDni(String isdn) {
        Libro libro = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            libro = session.createQuery("FROM Libro l WHERE l.isdn = :id", Libro.class)
                    .setParameter("id", isdn).getSingleResult();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return libro;
    }

    public List<Libro> getLibros() {
        List<Libro> libro = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {

            libro = session.createQuery("FROM Libro", Libro.class).getResultList();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return libro;
    }


}
