package DAO;

import Database.HibernateUtil;
import Model.Combustible;
import Model.Estado;
import Model.Marca;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EstadoDAO {
    private Session session;
    private Transaction transaction;

    public Estado getEstadoPorId(int id){
        Estado estado = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        estado = session.find(Estado.class, id);

        transaction.commit();
        session.close();

        return estado;
    }

    public Estado getEstado(String estado){
        Estado est = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            est = session.createQuery("FROM Estado WHERE lower(nombre) = lower(:e)", Estado.class)
                    .setParameter("e", estado.trim()).setMaxResults(1).uniqueResult();
        } catch (Exception e) {
            System.out.println("Error en EstadoDAO: " + e.getMessage());
        } finally {
            session.close();
        }
        return est;
    }
}
