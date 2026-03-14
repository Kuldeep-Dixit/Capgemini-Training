package com.abes.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="abes_customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name", nullable = false, length = 45)
    private String customerName;


    @OneToMany(mappedBy="customer")
    private List<Order> orders;

    public Customer(){}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }    

}