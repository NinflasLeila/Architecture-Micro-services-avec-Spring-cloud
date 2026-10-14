
package net.nineflas.inventoryservice;

import net.nineflas.entities.Product;
import net.nineflas.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {

            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(10)
                    .build());

            productRepository.save(Product.builder()
                    .name("Laptop")
                    .price(8500)
                    .quantity(5)
                    .build());

            productRepository.save(Product.builder()
                    .name("Mouse")
                    .price(150)
                    .quantity(25)
                    .build());

            productRepository.save(Product.builder()
                    .name("Keyboard")
                    .price(350)
                    .quantity(15)
                    .build());
        };
    }
}
