package mvoronin.lr4.testrest2dbh2.service;

import mvoronin.lr4.testrest2dbh2.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
