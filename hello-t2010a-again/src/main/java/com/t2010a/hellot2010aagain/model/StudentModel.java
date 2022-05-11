package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;

import java.util.List;

public interface StudentModel {
    Student save(Student student); // lưu thông tin.

    List<Student> findAll();

    Student findById(String rollNumber);

    Student update(String rollNumber, Student updateStudent);

    boolean delete(String rollNumber);
}
