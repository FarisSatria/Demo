package com.swamedia.apiserver.controller;

import com.swamedia.apiserver.entity.SiswaEntity;
import com.swamedia.apiserver.service.SiswaService;
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

    @GetMapping("/{id}")
    public SiswaEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new IllegalStateException("Student with ID " + id + " not found"));
    }

    @PostMapping
    public void registerNewStudent(@RequestBody SiswaEntity student) {
        studentService.addNewStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody SiswaEntity newSiswaData) {
        studentService.updateStudent(id, newSiswaData);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
