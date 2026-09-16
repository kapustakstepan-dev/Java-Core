package dao;

import database.HibernateUtil;
import jakarta.persistence.NoResultException;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public ProductDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void insertProducts(List<Product> list) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        list.forEach(item ->
        {
            session.persist(item);
        });

        transaction.commit();
        session.close();

    }

    // un usuario compra un producto
    // reducir stock +++


    // un producto cambia de precio +++

    // saldo -> reduce el precio del producto

    // eliminar un producto

    // tercera tabla para poder comprar un producto

    public List<Product> showData(){
        List<Product> lista = new ArrayList<>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {

            lista = session.createQuery("FROM Product", Product.class)
                            .getResultList();

            transaction.commit();
        } catch (NoResultException e){
            System.out.println("No se encuentran los productos");
            transaction.rollback();
        } catch (Exception e){
            transaction.rollback();
        } finally {
            session.close();
        }

        return lista;
    }

    public Product compraProducto(int id, int cantidad){
        Product product = null;

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        try {
            product = session.createQuery("FROM Product p WHERE p.id = :id", Product.class)
                    .setParameter("id", id).getSingleResult();

            if (product!=null){
                product.setStock(product.getStock() - cantidad);
            }

            transaction.commit();
        } catch (NoResultException e){
            System.out.println("No se encuentra al producto en ek stock");
            transaction.rollback();
        } catch (Exception e){
            transaction.rollback();
        } finally {
            session.close();
        }

        return product;
    }

    public Product cambioDePrecio(int id, double price){
        Product product = null;

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            product = session.createQuery("FROM Product p WHERE p.id = :id", Product.class)
                            .setParameter("id", id).getSingleResult();
            if (product!=null){
                product.setPrice(price);
            }

            transaction.commit();
        } catch (NoResultException e){
            System.out.println("No se encuentra este producto");
            transaction.rollback();
        } catch (Exception e){
            transaction.rollback();
        } finally {
            session.close();
        }

        return product;
    }

    public Product compra(int idUser, int idProducto, int cantidad){
        Product product = null;
        User user;
        Compra compra;
        DetalleCompra detalleCompra;

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        try {
            product = session.createQuery("FROM Product p WHERE p.id = :idPr", Product.class)
                    .setParameter("idPr", idProducto).getSingleResult();

            user = session.createQuery("FROM User u WHERE u.id = :idU", User.class)
                    .setParameter("idU", idUser).getSingleResult();

            if (product != null){
                double totalPago = product.getPrice() * cantidad;

                session.createMutationQuery("UPDATE User u SET u.saldo = u.saldo - :tot WHERE u.id = :idU")
                        .setParameter("tot", totalPago).setParameter("idU", idUser).executeUpdate();

                session.createMutationQuery("UPDATE Product p SET p.stock = p.stock - :cant WHERE p.id = :idP")
                        .setParameter("cant", cantidad).setParameter("idP", idProducto).executeUpdate();

                compra = new Compra();
                compra.setUser(user);
                compra.setTotal(totalPago);
                session.persist(compra);

                detalleCompra = new DetalleCompra();
                detalleCompra.setCompra(compra);
                detalleCompra.setProduct(product);
                detalleCompra.setCantidad(cantidad);
                detalleCompra.setPrecioTotal(product.getPrice());
                session.persist(detalleCompra);

                transaction.commit();
            }
        } catch (NoResultException e){
            System.out.println("No se encuentra el producto");
        } catch (Exception e){
            transaction.rollback();
        } finally {
            session.close();
        }

        return product;
    }

    public Product eliminarProducto(int id){
        Product product = null;

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        try {
            product = session.createQuery("FROM Product p WHERE p.id = :idP", Product.class)
                    .setParameter("idP", id).getSingleResult();

            if (product != null){
                session.createMutationQuery("DELETE FROM Product p WHERE p.id = :idP")
                        .setParameter("idP", id).executeUpdate();
            }
            transaction.commit();
        } catch (NoResultException e){
            System.out.println("No h podido encontrar el producto para borarle");
        } catch (Exception e){
            transaction.rollback();
        } finally {
            session.close();
        }

        return product;
    }
}