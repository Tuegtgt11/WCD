package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlStudentModel implements StudentModel{
    @Override
    public Student save(Student student) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into students " +
                    "(rollNumber, fullName, email, phone, dob, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, student.getRollNumber());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getDob().toString());
            preparedStatement.setString(6, student.getCreatedAt().toString());
            preparedStatement.setString(7, student.getUpdatedAt().toString());
            preparedStatement.setInt(8, student.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from students where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String rollNumber = resultSet.getString("rollNumber");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Student student = new Student(rollNumber, fullName, email, phone, dob, createdAt, updatedAt, status);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Student findById(String rollNumber) {
        Student student = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from students where status = ? and rollNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, rollNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                student = new Student(rollNumber, fullName, email, phone, dob, createdAt, updatedAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student update(String rollNumber, Student updateStudent) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update students " +
                    "set rollNumber = ?, fullName = ?, email = ?, phone = ?, dob = ?, createdAt = ?, updatedAt = ?, status = ? where rollNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateStudent.getRollNumber());
            preparedStatement.setString(2, updateStudent.getFullName());
            preparedStatement.setString(3, updateStudent.getEmail());
            preparedStatement.setString(4, updateStudent.getPhone());
            preparedStatement.setString(5, updateStudent.getDob().toString());
            preparedStatement.setString(6, updateStudent.getCreatedAt().toString());
            preparedStatement.setString(7, updateStudent.getUpdatedAt().toString());
            preparedStatement.setInt(8, updateStudent.getStatus());
            preparedStatement.setString(9, rollNumber);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateStudent;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String rollNumber) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update students " +
                    "set status = ? where rollNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setString(2, rollNumber);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
