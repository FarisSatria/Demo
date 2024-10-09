package com.swamedia.apiserver.controller;

import com.swamedia.apiserver.entity.SiswaEntity;
import com.swamedia.apiserver.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class SiswaController {

    private final SiswaService siswaService;

    @Autowired
    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @GetMapping
    public List<SiswaEntity> getStudents() {
        return siswaService.getStudents();
    }

    @GetMapping("/{id}")
    public SiswaEntity getStudentById(@PathVariable Long id) {
        return siswaService.getStudentById(id)
                .orElseThrow(() -> new IllegalStateException("Student with ID " + id + " not found"));
    }

    @PostMapping
    public void registerNewStudent(@RequestBody SiswaEntity student) {
        siswaService.addNewStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody SiswaEntity newSiswaData) {
        siswaService.updateStudent(id, newSiswaData);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        siswaService.deleteStudent(id);
    }
}
