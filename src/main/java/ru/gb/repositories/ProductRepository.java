package ru.gb.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.objects.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepository {
    private final HashMap<Integer, Product> list;

    public ProductRepository() {
        list = new HashMap<Integer, Product>();
        list.put(1, new Product(1, "Toy1", 21.0));
        list.put(2, new Product(2, "Toy2", 22.0));
        list.put(3, new Product(3, "Toy3", 23.0));
        list.put(4, new Product(4, "Toy4", 24.0));
        list.put(5, new Product(5, "Toy5", 25.0));
    }

    public List<Product> getList() {
        return new ArrayList<Product>(list.values());
    }

    public Product getById(Integer id) {
        return list.get(id);
    }

    // ╮(￣ω￣;)╭
    public void addProduct(Product product) {
        this.list.put(product.getId(), product);
    }
}
