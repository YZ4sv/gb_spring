package ru.gb;

import ru.gb.entity.CustomerProduct;
import ru.gb.services.CustomerProductService;

public class Application {
    public static void main(String[] args) {
        var service = new CustomerProductService();

        var listByCustomerId = service.findAllProducts(1);

        for (CustomerProduct order :
                listByCustomerId) {
            System.out.println(
                    "Товар: " + order.getProduct().getTitle() + "(" + order.getProduct_price() + ")"
            );
        }
    }
}
