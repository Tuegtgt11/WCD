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

public class DetailCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public DetailCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham sô id
        String id =req.getParameter("id");
        //kiểm tra trong database xem có tồn tại không.
        Customer customer = customerModel.findById(id);
        // nêu không trả về trang 404
        if (customer == null) {
            req.setAttribute("messages", "Customer not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            // nếu có trả về detail
            HttpSession session = req.getSession();
            ArrayList<Customer> recentView = (ArrayList<Customer>) session.getAttribute("recentView");
            if (recentView == null){
                recentView = new ArrayList<Customer>();
            }
            boolean exist = false;
            for (int i = 0; i< recentView.size(); i++) {
                if (recentView.get(i).getId().equals(customer.getId())){
                    exist = true;
                }
            }
            if (!exist){
                recentView.add(customer);
                session.setAttribute("recentView", recentView);
            }
            req.setAttribute("customer", customer);
            req.getRequestDispatcher("/admin/customers/detail.jsp").forward(req, resp);
        }
    }
}
