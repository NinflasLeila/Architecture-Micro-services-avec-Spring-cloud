package net.nineflas.customerservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.*;
import jakarta.persistence.Id;
import javax.annotation.processing.Generated;




@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {

    @Id
    @GeneratedValue
    private Long id ;
    private String name ;
    private String email;
}

