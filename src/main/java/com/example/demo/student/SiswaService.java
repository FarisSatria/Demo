package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {

    private final SiswaRepository studentRepository;

    @Autowired
    public SiswaService(SiswaRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<SiswaEntity> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(SiswaEntity student) {
        Optional<SiswaEntity> studentOptional = studentRepository
                .findStudentByNisn(student.getNisn());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Nisn taken");
        }
        studentRepository.save(student);
    }
}
