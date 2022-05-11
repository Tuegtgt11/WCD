package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlStudentModelTest {
    StudentModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlStudentModel();
    }

    @Test
    void save() {
        model.save(new Student("A003", "Hong", "hong@gmail.com", "0123123132", LocalDateTime.of(2004, 10, 10, 10, 10)));
    }

    @Test
    void findAll() {
        List<Student> list = model.findAll();
        for (Student st :
                list) {
            System.out.println(st.toString());
        }
    }

    @Test
    void findById() {
        Student student = model.findById("A001");
        assertEquals("Hung", student.getFullName());
        Student student1 = model.findById("A002");
        assertEquals("Luyen", student1.getFullName());
    }

    @Test
    void update() {
        Student student = model.findById("A001");
        student.setFullName("Xuan Van Hung");
        model.update("A001", student);
        Student newUpdateStudent = model.findById("A001");
        assertEquals("Xuan Van Hung", newUpdateStudent.getFullName());
    }

    @Test
    void delete() {
        model.delete("A001");
        Student student = model.findById("A001");
        assertEquals(null, student);
    }

}