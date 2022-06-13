package com.ldnhat.springbootecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private Set<Orders> orders = new HashSet<>();

    public void add(Orders order){
        if(order != null){
            if (orders == null){
                orders = new HashSet<>();
            }
            orders.add(order);
            order.setCustomerEntity(this);
        }
    }
}
