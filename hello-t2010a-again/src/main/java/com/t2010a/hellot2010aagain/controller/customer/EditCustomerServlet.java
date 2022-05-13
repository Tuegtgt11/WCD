package com.t2010a.hellot2010aagain.controller.customer;

import com.t2010a.hellot2010aagain.entity.Customer;
import com.t2010a.hellot2010aagain.model.customer.CustomerModel;
import com.t2010a.hellot2010aagain.model.customer.MySqlCustomerModel;
import com.t2010a.hellot2010aagain.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class EditCustomerServlet extends HttpServlet {

    private CustomerModel customerModel;

    public EditCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham sô id
        String id = req.getParameter("id");
        // kiểm tra trong database xem có tồn tại không}
        Customer customer = customerModel.findById(id);
        // nếu không có trả về trang 404
        if (customer == null) {
            req.setAttribute("message", "Customer not forund!");
        } else {
            req.setAttribute("customer", customer);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lí validate và save
        String id = req.getParameter("id");
        Customer existingCustomer = customerModel.findById(id);
        if(existingCustomer == null){
            req.setAttribute("message", "Customer not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else{
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String image = req.getParameter("image");
            String stringBirthday = req.getParameter("birthday");
            System.out.println(name);
            LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
            Customer customer = new Customer(id, name, phone, image, birthday);
            // validate dữ liệu
            if (customerModel.update(id, customer) != null) {
                resp.sendRedirect("/admin/customers/list");
            } else {
                // nếu có trả về trang form
                req.setAttribute("customer", customer);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
            }
        }
    }
}
