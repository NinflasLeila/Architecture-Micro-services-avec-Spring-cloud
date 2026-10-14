package net.nineflas.customerservice;

import net.nineflas.customerservice.entities.Customer;
import net.nineflas.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    };

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Mohamed").email("med@gmail.com").build());

            customerRepository.save(Customer.builder()
                    .name("laila").email("laila@gmail.com").build());


            customerRepository.save(Customer.builder()
                    .name("jalil").email("jalil@gmail.com").build());


        };

    }

}
