package net.nineflas.billingservice.entities;


import jakarta.persistence.*;
import lombok.*;
import net.nineflas.billingservice.model.Customer;
import net.nineflas.billingservice.model.Product;

import java.util.Date;
import java.util.List;

@Entity @Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {

    @Id
    @GeneratedValue
    private String id;
    private Date billingDate;
    private Long customerId;
    @OneToMany(mappedBy="bill")
    private List<ProductItem> productItemList;
    @Transient
    private Customer customer;


    
}
