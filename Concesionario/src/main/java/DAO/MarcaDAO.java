package DAO;

import Database.HibernateUtil;
import Model.Coche;
import Model.Marca;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MarcaDAO {

    private Session session;
    private Transaction transaction;

    public Marca getMarcaPorId(int id){
        Marca marca;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        marca = session.find(Marca.class, id);

        transaction.commit();
        session.close();

        return marca;
    }

    private List<Coche> getAllCochesFromMarca(String marcaStr){
        List<Coche> lista;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        Marca marca = session.createQuery("FROM Marca m WHERE m.marca = :nombre",Marca.class)
                        .setParameter("nombre", marcaStr).getSingleResult();

        lista = marca.getListaCoches();


        transaction.commit();
        session.close();

        return lista;
    }

    public Marca getMarca(String marca){
        Marca mar = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            mar = session.createQuery("FROM Marca WHERE lower(marca) = lower(:m)", Marca.class)
                    .setParameter("m", marca.trim()).setMaxResults(1).uniqueResult();
        } catch (Exception e) {
            System.out.println("Error en MarcaDAO");
        } finally {
            session.close();
        }
        return mar;
    }

}
