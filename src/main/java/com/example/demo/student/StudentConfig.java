package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;
import static java.time.Month.FEBRUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student faris = new Student(
                    1L,
                    "Faris",
                    "satria.faris@gmail.com",
                    LocalDate.of(2007, FEBRUARY, 4),
                    17
            );

            Student aleks = new Student(
                    1L,
                    "Aleks",
                    "Elaks@gmail.com",
                    LocalDate.of(2006, FEBRUARY, 4),
                    18
            );

            repository.saveAll(
                    List.of(faris, aleks)
            );
        };
    }
}
