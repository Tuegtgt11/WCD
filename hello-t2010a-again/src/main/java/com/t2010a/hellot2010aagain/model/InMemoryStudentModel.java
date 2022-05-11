package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentModel implements StudentModel{
    private static List<Student> students;

    public InMemoryStudentModel() {
        students = new ArrayList<>();
        students.add(
                new Student(
                        "A001",
                        "Xuan Hung",
                        "xuanhung@gmail.com",
                        "0912345678",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        students.add(
                new Student(
                        "A002",
                        "Xuan Sang",
                        "xuansang@gmail.com",
                        "0912345679",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        students.add(
                new Student(
                        "A003",
                        "Xuan Thi",
                        "xuanthi@gmail.com",
                        "0912345679",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        students.add(
                new Student(
                        "A004",
                        "Xuan Dieu",
                        "xuandieu@gmail.com",
                        "0912345689",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(String rollNumber) {
        Student foundStudent = null;
        for (Student student :
                students) {
            if (student.getRollNumber().equals(rollNumber)) {
                foundStudent = student;
                break;
            }
        }
        return foundStudent;
    }

    @Override
    public Student update(String rollNumber, Student updateStudent) {
        Student existingStudent = findById(rollNumber);
        if(existingStudent == null){
            return null;
        }
        existingStudent.setFullName(updateStudent.getFullName());
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setPhone(updateStudent.getPhone());
        existingStudent.setDob(updateStudent.getDob());
        existingStudent.setUpdatedAt(LocalDateTime.now());
        existingStudent.setStatus(updateStudent.getStatus());
        return existingStudent;
    }

    @Override
    public boolean delete(String rollNumber) {
        int foundIndex = -1;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getRollNumber().equals(rollNumber)){
                foundIndex = i;
            }
        }
        if(foundIndex != -1){
            students.remove(foundIndex);
            return true;
        }
        return false;
    }
}
