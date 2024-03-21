package com.loginmodule.loginmodule.entities.products;

//import com.loginmodule.loginmodule.Auditing.Auditable;

import com.loginmodule.loginmodule.Auditing.Auditable;
import com.loginmodule.loginmodule.entities.users.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductReview extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String review;
    private Double rating;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
