package ru.gb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.repositories.ProductRepository;

@Controller
public class HomeController {
    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("productList", this.productRepository.getList());

        return "index";
    }

    @GetMapping("/product")
    public String product(Model model, @RequestParam("id") int id) {
        var product = this.productRepository.getById(id);

        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден");
        }

        model.addAttribute("product", product);

        return "product";
    }
}
