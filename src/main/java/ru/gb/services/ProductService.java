package ru.gb.services;

import org.springframework.stereotype.Service;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;

import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao = new ProductDao();

    public ProductService() {
    }

    public Product findProduct(int id) {
        return productDao.findById(id);
    }

    public void saveProduct(Product product) {
        productDao.save(product);
    }

    public void deleteProduct(Product product) {
        productDao.delete(product);
    }

    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    public void saveOrUpdate(Product product) {
        if (product.getId() == null) {
            productDao.save(product);
        } else {
            productDao.update(product);
        }
    }

    public void deleteById(Integer id) {
        var model = this.findProduct(id);

        if (model == null) {
            return;
        }

        this.deleteProduct(model);
    }
}
