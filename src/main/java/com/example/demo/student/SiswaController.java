package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class SiswaController {

    private final SiswaService studentService;

    @Autowired
    public SiswaController(SiswaService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<SiswaEntity> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody SiswaEntity student) {
        studentService.addNewStudent(student);
    }
}
