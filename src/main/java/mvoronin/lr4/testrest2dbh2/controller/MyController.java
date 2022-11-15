package mvoronin.lr4.testrest2dbh2.controller;

import lombok.Data;
import mvoronin.lr4.testrest2dbh2.entity.Student;
import mvoronin.lr4.testrest2dbh2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> showAllStudents() {
        var allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }
}