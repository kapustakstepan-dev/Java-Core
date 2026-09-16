package dao;

import basedatos.HibernateUtil;
import jakarta.persistence.NoResultException;
import model.Autor;
import model.Biblioteca;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BibliotecaDAO {
    private Session session;
    private Transaction transaction;

    public List<Biblioteca> getLibros (String calle){
        List<Biblioteca> bibliotecas = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            bibliotecas = session.createQuery("FROM Biblioteca b WHERE b.calle = :c", Biblioteca.class)
                            .setParameter("c", calle).getResultList();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return bibliotecas;

    }
}
