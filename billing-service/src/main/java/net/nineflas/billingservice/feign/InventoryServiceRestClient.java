package net.nineflas.billingservice.feign;

import net.nineflas.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {

    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inventoryService")
    Product getProduct(@PathVariable("id") Long id);
}