package DAO;

import Database.HibernateUtil;
import Model.Coche;
import Model.Estado;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CocheDAO {
    private Transaction transaction;
    private Session session;

    public Coche insertarCoche(Coche coche){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        session.merge(coche);
        transaction.commit();

        session.close();
        return coche;
    }

    public List<Coche> showData(){
        List<Coche> lista = new ArrayList<>();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.getTransaction();
        try {
            lista = session.createQuery("FROM Coche", Coche.class)
                    .getResultList();

            transaction.commit();
        } catch (NoResultException e){
            System.out.println("Sin resultado");
        } catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }



        return lista;
    }

    public Coche sacarPorMatricula(String matricula){
        Coche coche = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {

            coche = session.createQuery("FROM Coche c WHERE c.matricula = :mat", Coche.class)
                            .setParameter("mat", matricula).getSingleResult();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("No se puede sacar los datos");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return coche;
    }

    public List<Coche> getPorMarca(String marca){
        List<Coche> coche = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            coche = session.createQuery("FROM Coche c WHERE c.marca.marca = :m", Coche.class)
                    .setParameter("m", marca).getResultList();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultados");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }


        return coche;
    }

    public List<Coche> getPorModelo(String modelo){
        List<Coche> coche = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {

            coche = session.createQuery("FROM Coche c WHERE c.modelo = :m", Coche.class)
                            .setParameter("m", modelo).getResultList();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultado");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }


        return coche;
    }

    public List<Coche> getRangoPrecio(int min, int max){
        List<Coche> lista = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            lista = session.createQuery("FROM Coche c WHERE c.precio BETWEEN :pMin AND :pMax", Coche.class)
                            .setParameter("pMin", min).setParameter("pMax", max).getResultList();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultado");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return lista;
    }

    public List<Coche> getPorEstado(String estado){
        List<Coche> lista = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {

            lista = session.createQuery("FROM Coche c WHERE c.estado.estado = :e", Coche.class)
                            .setParameter("e", estado).getResultList();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultado");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return lista;
    }

    public Coche actualizarDatosCoche(String matricula, int km, String estado, int precio){
        Coche coche = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            coche = session.createQuery("FROM Coche c WHERE c.matricula = :mat",Coche.class)
                            .setParameter("mat", matricula).getSingleResult();

            if (coche.getMatricula()!= null){
                coche.setKm(km);
                coche.setEstado(new Estado(estado));
                coche.setPrecio(precio);
            }
            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultado");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return coche;
    }

    public Coche getPorMatriculaVenta(String matricula){
        Coche coche = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            coche = session.createQuery("FROM Coche c WHERE c.matricula = :m ", Coche.class)
                    .setParameter("m", matricula).uniqueResult();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultado");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return coche;

    }

    public int eliminarCochePorMatricula(String matricula) throws Exception{
        int cocheBorrado = 0;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            cocheBorrado = session.createMutationQuery("DELETE FROM Coche c WHERE c.matricula = :m")
                            .setParameter("m", matricula).executeUpdate();

            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Sin resultado");
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return cocheBorrado;

    }

    public List<Coche> getCochesPorCombustible(String combustible){
        List<Coche> lista = null;

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            lista = session.createQuery("FROM Coche c WHERE lower(c.combustible.tipo) = lower(:c)", Coche.class)
                            .setParameter("c", combustible).getResultList();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }


        return lista;
    }

    public List<Coche> getCochesPorMarca(String marca) {
        List<Coche> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            lista = session.createQuery("FROM Coche c WHERE lower(c.marca.marca) = lower(:m)", Coche.class)
                    .setParameter("m", marca).getResultList();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return lista;
    }

    public List<Coche> getCochesDisponibles() {
        List<Coche> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            lista = session.createQuery("FROM Coche c WHERE lower(c.estado.nombre) = 'stock' ", Coche.class)
                    .getResultList();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return lista;
    }

    public List<Coche> getCochesVendidos() {
        List<Coche> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            lista = session.createQuery("FROM Coche c WHERE lower(c.estado.nombre) = 'vendido' ", Coche.class)
                    .getResultList();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return lista;
    }

    public List<Coche> getTodosCoches() {
        List<Coche> lista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            lista = session.createQuery("FROM Coche", Coche.class).getResultList();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return lista;
    }
}
