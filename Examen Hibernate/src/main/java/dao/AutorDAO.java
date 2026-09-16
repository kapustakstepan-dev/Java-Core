package dao;


import basedatos.HibernateUtil;
import jakarta.persistence.NoResultException;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AutorDAO {
    private Session session;
    private Transaction transaction;

    public Autor insertarAutor(Autor autorInsert){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.persist(autorInsert);

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        }finally {
            session.close();
        }

        return autorInsert;
    }

    public Autor getPorDni(String dni) {
        Autor autor = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            autor = session.createQuery("FROM Autor a WHERE a.dni = :dni", Autor.class)
                    .setParameter("dni", dni).getSingleResult();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return autor;
    }

    public Autor getLibros(String dni) {
        Autor autor = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            autor = session.createQuery("FROM Autor a WHERE a.dni = :dni", Autor.class)
                    .setParameter("dni", dni).getSingleResult();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return autor;
    }


}
