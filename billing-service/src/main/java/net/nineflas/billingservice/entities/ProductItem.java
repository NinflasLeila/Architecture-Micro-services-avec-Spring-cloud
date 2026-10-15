package net.nineflas.billingservice.entities;


import jakarta.persistence.*;
import lombok.*;
import net.nineflas.billingservice.model.Product;

@Entity
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class ProductItem {

    @Id
    @GeneratedValue
    private Long id;
    private long productId;
    private int quantity ;
    private double price;
    @ManyToOne
    private Bill bill ;
    @Transient
    private Product product;


}
