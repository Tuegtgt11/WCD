package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCustomerModelTest {

    CustomerModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlCustomerModel();
    }

    @Test
    void save() {
        model.create(new Customer("ABD1", "Dat", "0202151554", "adad.jpg", LocalDateTime.of(2004, 10, 10, 10, 10)));
    }

    @Test
    void findAll() {
        List<Customer> list = model.findAll();
        for (Customer st :
                list) {
            System.out.println(st.toString());
        }
    }

    @Test
    void findById() {
        Customer customer = model.findById("AB1");
        assertEquals("Dat", customer.getName());
        Customer customer1 = model.findById("A002");
        assertEquals("Luyen", customer1.getName());
    }

    @Test
    void update() {
        Customer customer = model.findById("A001");
        customer.setName("Xuan Van Hung");
        model.update("A001", customer);
        Customer newUpdateCustomer = model.findById("A001");
        assertEquals("Xuan Van Hung", newUpdateCustomer.getName());
    }

    @Test
    void delete() {
        model.delete("A001");
        Customer customer = model.findById("A001");
        assertEquals(null, customer);
    }
}