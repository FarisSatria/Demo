package com.swamedia.apiserver.service;

import com.swamedia.apiserver.entity.SiswaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swamedia.apiserver.repository.SiswaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {

    private final SiswaRepository siswaRepository;

    @Autowired
    public SiswaService(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
    }

    public List<SiswaEntity> getStudents(){
        return siswaRepository.findAll();
    }

    public Optional<SiswaEntity> getStudentById(Long id) {
        return siswaRepository.findById(id);
    }

    public void addNewStudent(SiswaEntity student) {
        Optional<SiswaEntity> studentOptional = siswaRepository
                .findSiswaByNisn(student.getNisn());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Nisn taken");
        }
        siswaRepository.save(student);
    }

    public void updateStudent(Long id, SiswaEntity newSiswaData) {
        SiswaEntity student = siswaRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Siswa dengan ID " + id + " tidak ada"));

        if (newSiswaData.getNama() != null && !newSiswaData.getNama().isEmpty()) {
            student.setNama(newSiswaData.getNama());
        }

        if (newSiswaData.getNisn() != null && !newSiswaData.getNisn().equals(student.getNisn())) {
            Optional<SiswaEntity> studentOptional = siswaRepository.findSiswaByNisn(newSiswaData.getNisn());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Nisn taken");
            }
            student.setNisn(newSiswaData.getNisn());
        }

        if (newSiswaData.getAlamat() != null && !newSiswaData.getAlamat().isEmpty()) {
            student.setAlamat(newSiswaData.getAlamat());
        }

        if (newSiswaData.getKelas() != null && !newSiswaData.getKelas().isEmpty()) {
            student.setKelas(newSiswaData.getKelas());
        }

        siswaRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = siswaRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Siswa dengan ID " + id + " tidak ada");
        }
        siswaRepository.deleteById(id);
    }


}
