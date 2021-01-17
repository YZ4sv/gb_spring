package ru.gb.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.objects.Product;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    private final HashMap<Integer, Product> List;

    public ProductRepository()
    {
        List = new HashMap<Integer, Product>();
        List.put(1, new Product(1, "Toy1", 21.0));
        List.put(2, new Product(2, "Toy2", 22.0));
        List.put(3, new Product(3, "Toy3", 23.0));
        List.put(4, new Product(4, "Toy4", 24.0));
        List.put(5, new Product(5, "Toy5", 25.0));
    }

    public Map<Integer, Product> getList()
    {
        return List;
    }

    public Product getById(Integer id)
    {
        return List.get(id);
    }
}
