package ru.gb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.gb.objects.Cart;
import ru.gb.services.ConsoleService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        Cart cart = (Cart) context.getBean(Cart.class);
        ConsoleService consoleService = (ConsoleService) context.getBean(ConsoleService.class);

        consoleService.printStartMessage();

        while (true) {
            var command = consoleService.getCommand();

            if (command.equals(ConsoleService.LIST_COMMAND)) {
                consoleService.printProductList();
            } else  if (command.equals(ConsoleService.CART_COMMAND)) {
                consoleService.printCart(cart);
            } else if (command.startsWith(ConsoleService.ADD_COMMAND)) {
                var id = consoleService.getIdFromCommand(command);

                cart.addProductById(id);
            } else if (command.startsWith(ConsoleService.REMOVE_COMMAND)) {
                var id = consoleService.getIdFromCommand(command);

                cart.removeByProductId(id);
            } else {
                System.out.println("Команда не доступна");
            }
        }
    }

    @Bean
    public Cart cart() {
        return new Cart();
    }
}
