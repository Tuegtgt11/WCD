package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel{
    private static List<Customer> customers;

    public InMemoryCustomerModel(){
        customers = new ArrayList<>();
        customers.add(
                new Customer("AB1",
                        "Robert Vu",
                        "028812122",
                        "adj.jpg",
                        LocalDateTime.of(2002,3,28,10,10),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer("AB2",
                        "Robert Tue",
                        "0225191282",
                        "adj5.jpg",
                        LocalDateTime.of(2002,3,28,10,10),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }

    @Override
    public Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String Id) {
        Customer foundCus = null;
        for (Customer customer:
                customers){
            if (customer.getId().equals(Id)){
                foundCus = customer;
                break;
            }

        }
        return foundCus;
    }

    @Override
    public Customer update(String Id, Customer updateCustomer) {
        Customer existingCus = findById(Id);
        if (existingCus == null){
            return null;
        }
        existingCus.setName(updateCustomer.getName());
        existingCus.setPhone(updateCustomer.getPhone());
        existingCus.setImage(updateCustomer.getImage());
        existingCus.setDOB(updateCustomer.getDOB());
        existingCus.setCreatedAt(LocalDateTime.now());
        existingCus.setUpdatedAt(LocalDateTime.now());
        existingCus.setStatus(updateCustomer.getStatus());
        return existingCus;

    }

    @Override
    public boolean delete(String Id) {
        int foundIndex = -1;
        for (int i = 0;i < customers.size();i++ ){
            if(customers.get(i).getId().equals(Id)){
                foundIndex = i;
            }
        }
        if (foundIndex !=-1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}
