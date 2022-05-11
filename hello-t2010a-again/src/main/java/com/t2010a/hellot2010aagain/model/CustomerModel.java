package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Customer;

import java.util.List;

public interface CustomerModel {
    Customer create(Customer customer);

    List<Customer> findAll();


    Customer findById(String Id);

    Customer update(String Id, Customer updateCustomer);

    boolean delete(String Id);
}
