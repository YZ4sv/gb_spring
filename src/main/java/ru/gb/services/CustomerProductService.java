package ru.gb.services;

import ru.gb.dao.CustomerProductDao;
import ru.gb.entity.CustomerProduct;

import java.util.List;

public class CustomerProductService {
    private final CustomerProductDao CustomerProductDao = new CustomerProductDao();

    public List<CustomerProduct> findAllProducts(int customerId) {
        return CustomerProductDao.findAllByCustomerId(customerId);
    }
}
