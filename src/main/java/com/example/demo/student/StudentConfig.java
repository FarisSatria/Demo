package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.FEBRUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            StudentEntity faris = new StudentEntity(
                    391120221,
                    "Faris",
                    "JL.Asem Barat No.46 RT.03 RW.04",
                    "XII RPL 1"
            );

            repository.saveAll(
                    List.of(faris)
            );
        };
    }
}
