package ru.gb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.objects.Cart;
import ru.gb.objects.Product;
import ru.gb.repositories.ProductRepository;

import java.util.Scanner;

@Service
public class ConsoleService {
    @Autowired
    private ProductRepository productRepository;

    public static final String LIST_COMMAND = "list";
    public static final String CART_COMMAND = "cart";
    public static final String ADD_COMMAND = "add";
    public static final String REMOVE_COMMAND = "remove";

    public void printStartMessage() {
        System.out.println(
                "Доступные команды:\n" +
                        ConsoleService.LIST_COMMAND + " - список всех товаров\n" +
                        ConsoleService.CART_COMMAND + " - список товаров в корзине\n" +
                        ConsoleService.ADD_COMMAND + " {id} - добавить товар в корзину\n" +
                        ConsoleService.REMOVE_COMMAND + " {id} - удалить товар из корзины"
        );
    }

    public String getCommand() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите команду: ");

        String command = "";
        command = in.nextLine();

        in.close();

        return command;
    }

    public void printProductList() {
        var list = productRepository.getList();

        for (int i = 1; i < list.size(); i++) {
            var product = list.get(i);
            this.printProduct(product);
        }
    }

    private void printProduct(Product product) {
        System.out.println(
                "#" + product.id + ": " + product.name + " (" + product.price + ")"
        );
    }

    public void printCart(Cart cart) {
        var productIdList = cart.getProductIdList();
        var productList = productRepository.getList();

        if (productIdList.size() == 0) {
            System.out.println("Корзина пуста");

            return;
        }

        for (Integer integer : productIdList) {
            var product = productList.get(integer);

            this.printProduct(product);
        }
    }

    public Integer getIdFromCommand(String command) {
        String numberOnly= command.replaceAll("[^0-9]", "");

        return Integer.parseInt(numberOnly);
    }
}
