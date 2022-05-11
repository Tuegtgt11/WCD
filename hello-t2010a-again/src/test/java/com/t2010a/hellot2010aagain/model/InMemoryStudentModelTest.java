package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryStudentModelTest {

    InMemoryStudentModel model;

    @BeforeEach
    void setUp() {
        model = new InMemoryStudentModel();
    }

    @Test
    void save() {
        System.out.println(model.findAll().size());
        Student student = new Student(
                "A005",
                "Xuan Hinh",
                "hinh@gmail.com",
                "091234555",
                LocalDateTime.of(2000, 10, 10, 0, 0)
        );
        model.save(student);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().size());
    }

    @Test
    void findById() {
        Student student = model.findById("A001");
        System.out.println(student.toString());
    }

    @Test
    void update() {
        Student student = model.findById("A001");
        student.setFullName("Dao Xuan Hung");
        model.update("A001", student);
        for (Student st: model.findAll()) {
            System.out.println(st.toString());
        }
    }

    @Test
    void delete() {
        model.delete("A001");
        for (Student st: model.findAll()) {
            System.out.println(st.toString());
        }
    }
}