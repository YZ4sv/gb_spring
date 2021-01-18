package ru.gb.objects;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gb.repositories.ProductRepository;

import java.util.ArrayList;

public class Cart {
    @Autowired
    private ProductRepository productRepository;

    private final ArrayList<Integer> productList;

    public Cart()
    {
        this.productList = new ArrayList<Integer>();
    }

    public void addProductById(int id)
    {
        Product product = productRepository.getById(id);

        if (product != null) {
            this.productList.add(id);
        }
    }

    public void removeByProductId(int id)
    {
        this.productList.remove(id);
    }

    public ArrayList<Integer> getProductIdList() {
        return productList;
    }
}
