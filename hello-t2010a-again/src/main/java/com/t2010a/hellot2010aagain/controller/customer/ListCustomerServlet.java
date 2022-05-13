package com.t2010a.hellot2010aagain.controller.customer;

import com.t2010a.hellot2010aagain.entity.Customer;
import com.t2010a.hellot2010aagain.model.customer.CustomerModel;
import com.t2010a.hellot2010aagain.model.customer.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public ListCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list =customerModel.findAll();
        req.setAttribute("listCustomer", list);
        req.getRequestDispatcher("/admin/customers/list.jsp").forward(req, resp);
    }
}
