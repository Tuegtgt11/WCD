package com.t2010a.hellot2010aagain.controller.customer;

import com.t2010a.hellot2010aagain.entity.Customer;
import com.t2010a.hellot2010aagain.model.customer.CustomerModel;
import com.t2010a.hellot2010aagain.model.customer.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecentCustomerServlet extends HttpServlet {

    private CustomerModel customerModel;
    public RecentCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Customer> list = (ArrayList<Customer>) session.getAttribute("recentView");
        if (list == null){
            list = new ArrayList<>();
        }
        req.setAttribute("title", "Recent View");
        req.setAttribute("listCustomer", list);
        req.getRequestDispatcher("/admin/customers/recentView.jsp").forward(req, resp);
    }
}
