package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.gb.objects.Cart;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        Cart cart = (Cart) context.getBean(Cart.class);
    }


    @Bean
    public Cart cart() {
        return new Cart();
    }
}
