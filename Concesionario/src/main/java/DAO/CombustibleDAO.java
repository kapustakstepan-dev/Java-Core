package DAO;

import Database.HibernateUtil;
import Model.Combustible;
import Model.Estado;
import Model.Marca;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CombustibleDAO {

    private Session session;
    private Transaction transaction;

    public Combustible getCombustiblePorId(int id){
        Combustible combustible = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        combustible = session.find(Combustible.class, id);

        transaction.commit();
        session.close();

        return combustible;
    }

    public Combustible getCombustible(String combustible){
        Combustible com = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            com = session.createQuery("FROM Combustible WHERE lower(tipo) = lower(:c)", Combustible.class)
                    .setParameter("c", combustible.trim()).setMaxResults(1).uniqueResult();
        } catch (Exception e) {
            System.out.println("Error en CombustibleDAO: " + e.getMessage());
        } finally {
            session.close();
        }
        return com;
    }
}
