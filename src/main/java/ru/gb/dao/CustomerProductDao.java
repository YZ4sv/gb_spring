package ru.gb.dao;

import ru.gb.entity.CustomerProduct;
import ru.gb.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CustomerProductDao {
    public List<CustomerProduct> findAllByCustomerId(int customerId) {
        var sql = String.format("SELECT * FROM customer_product_relation WHERE customer_id = %s;", customerId);

        List<CustomerProduct> customerProductList = (List<CustomerProduct>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From CustomerProduct where customer_id = " + customerId)
                .list();

        return customerProductList;
    }
}
