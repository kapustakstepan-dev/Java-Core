package DAO;


import Database.HibernateUtil;
import Model.Cliente;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ClientInfoStatus;

public class ClienteDAO {
    private Transaction transaction;
    private Session session;

    public Cliente getClienteByNif(String nif){
        Cliente cliente = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            cliente = session.createQuery("FROM Cliente c WHERE c.nif = :nif", Cliente.class)
                            .setParameter("nif", nif).uniqueResult();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultado");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return cliente;
    }
    public void insertCliente(Cliente cliente){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            session.persist(cliente);

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultado");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
