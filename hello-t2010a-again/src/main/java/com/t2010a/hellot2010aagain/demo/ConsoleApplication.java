package com.t2010a.hellot2010aagain.demo;

import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.model.InMemoryStudentModel;
import com.t2010a.hellot2010aagain.model.MySqlStudentModel;
import com.t2010a.hellot2010aagain.model.StudentModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static StudentModel studentModel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please choose type of model: ");
            System.out.println("--------------------------");
            System.out.println("1. In memory model.");
            System.out.println("2. My SQL model.");
            System.out.println("--------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    studentModel = new InMemoryStudentModel();
                    break;
                case 2:
                    studentModel = new MySqlStudentModel();
                    break;
            }
            generateMenu();
        }
    }

    private static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Student Manager--------------");
            System.out.println("1. Create new student");
            System.out.println("2. Show all student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createNewStudent();
                    break;
                case 2:
                    showAllStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Cya!");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }

    private static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter rollNumber to update: ");
        String rollNumber = scanner.nextLine();
        Student existingStudent = studentModel.findById(rollNumber);
        if (existingStudent == null) {
            System.err.println("404, Student not found!");
        } else {
            if (studentModel.delete(rollNumber)) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter rollNumber to update: ");
        String rollNumber = scanner.nextLine();
        Student existingStudent = studentModel.findById(rollNumber);
        if (existingStudent == null) {
            System.err.println("404, Student not found!");
        } else {
            System.out.println("Please enter full name");
            String name = scanner.nextLine();
            existingStudent.setFullName(name);
            if (studentModel.update(rollNumber, existingStudent) != null) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void showAllStudent() {
        List<Student> list = studentModel.findAll();
        for (Student student :
                list) {
            System.out.println(student.toString());
        }
    }

    private static void createNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter roll number");
        String rollNumber = scanner.nextLine();
        System.out.println("Please enter full name");
        String name = scanner.nextLine();
        Student student = new Student(rollNumber, name, "demo@gmail.com", "019231233", LocalDateTime.of(2000, 10, 10, 10, 10));
        if (studentModel.save(student) != null) {
            System.out.println("Create student success!");
        } else {
            System.err.println("Save student fails, please try again later!");
        }
    }
}
