package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Customer;
import com.t2010a.hellot2010aagain.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCustomerModel implements CustomerModel{
    @Override
    public Customer create(Customer customer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into customer " +
                    "(Id, Name, Phone, Image, DOB, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getImage());
            preparedStatement.setString(5, customer.getDOB().toString());
            preparedStatement.setString(6, customer.getCreatedAt().toString());
            preparedStatement.setString(7, customer.getUpdatedAt().toString());
            preparedStatement.setInt(8, customer.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return customer;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customer where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String Id = resultSet.getString("Id");
                String Name = resultSet.getString("Name");
                String Phone = resultSet.getString("Phone");
                String Image = resultSet.getString("Image");
                LocalDateTime DOB =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("DOB").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Customer customer = new Customer(Id, Name, Phone, Image, DOB, createdAt, updatedAt, status);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Customer findById(String Id) {
        Customer customer = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customer where status = ? and Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, Id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String Name = resultSet.getString("Name");
                String Phone = resultSet.getString("Phone");
                String Image = resultSet.getString("Image");
                LocalDateTime DOB =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("DOB").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                customer = new Customer(Id, Name, Phone, Image, DOB, createdAt, updatedAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;    }

    @Override
    public Customer update(String Id, Customer updateCustomer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customer " +
                    "set Id = ?, Name = ?, Phone = ?, Image = ?, DOB = ?, createdAt = ?, updatedAt = ?, status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateCustomer.getId());
            preparedStatement.setString(2, updateCustomer.getName());
            preparedStatement.setString(3, updateCustomer.getPhone());
            preparedStatement.setString(4, updateCustomer.getImage());
            preparedStatement.setString(5, updateCustomer.getDOB().toString());
            preparedStatement.setString(6, updateCustomer.getCreatedAt().toString());
            preparedStatement.setString(7, updateCustomer.getUpdatedAt().toString());
            preparedStatement.setInt(8, updateCustomer.getStatus());
            preparedStatement.setString(9, Id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String Id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customer " +
                    "set status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setString(2, Id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
