package com.t2010a.hellot2010aagain.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void testCreateCustomer(){
        Customer customer = new Customer();
        customer.setId("AB1");
        customer.setName("Robert Vu");
        customer.setPhone("0123456784");
        customer.setImage("adj.jpg");
        customer.setDOB(LocalDateTime.of(2002,02,16,12,00));
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setStatus(1);
        System.out.printf(customer.toString());


    }

}