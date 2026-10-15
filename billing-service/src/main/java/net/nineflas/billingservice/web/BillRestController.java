package net.nineflas.billingservice.web;


import jakarta.ws.rs.Path;
import net.nineflas.billingservice.entities.Bill;
import net.nineflas.billingservice.feign.CustomerServiceRestClient;
import net.nineflas.billingservice.feign.InventoryServiceRestClient;
import net.nineflas.billingservice.model.Customer;
import net.nineflas.billingservice.repositories.BillRepository;
import net.nineflas.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api")
public class BillRestController {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;



    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id ){
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        return bill ;
    }




}
