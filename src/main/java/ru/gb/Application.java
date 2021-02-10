package ru.gb;

import ru.gb.entity.Product;
import ru.gb.services.ProductService;

public class Application {
    public static void main(String[] args) {
        var service = new ProductService();

        var firstProduct = new Product("Test", 123);

        service.saveOrUpdate(firstProduct);

        var secondProduct = service.findProduct(1);
        secondProduct.setPrice(125);

        service.saveOrUpdate(secondProduct);

        service.deleteById(firstProduct.getId());

    }
}
