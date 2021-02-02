package ru.gb.dao;

import org.hibernate.Session;
import ru.gb.entity.Product;
import ru.gb.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductDao {
    public Product findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }

    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }

    public void update(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var tx1 = session.beginTransaction();
        session.update(product);
        tx1.commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }

    public Product findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }

    public List<Product> findAll() {
        List<Product> productList = (List<Product>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return productList;
    }
}
