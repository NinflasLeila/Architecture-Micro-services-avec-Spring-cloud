
package net.nineflas.billingservice.feign;

import net.nineflas.billingservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceRestClient{

    @GetMapping("/customers/{id}")
    @CircuitBreaker(
            name = "customerService",
            fallbackMethod = "getDefaultCustomer"
    )
    Customer findCustomerById(@PathVariable("id") Long id);

    default Customer getDefaultCustomer(Long id, Throwable exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Default customer name");
        customer.setEmail("default@gmail.com");
        return customer;
    }
}
