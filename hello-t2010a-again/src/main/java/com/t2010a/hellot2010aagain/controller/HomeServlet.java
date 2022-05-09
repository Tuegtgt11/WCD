package com.t2010a.hellot2010aagain.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        response.getWriter().println("Hello " + firstName + lastName);

        // xử lí logic
        // xử lí dữ liệu database
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
