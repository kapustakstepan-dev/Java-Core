package DAO;

import Database.HibernateUtil;
import Model.Cliente;
import Model.Coche;
import Model.Combustible;
import Model.Compra;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompraDAO {
    private Session session;
    private Transaction transaction;

    public void registrarCompra(Compra compraRegister, Coche coche){

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.merge(coche);

            session.persist(compraRegister);

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
