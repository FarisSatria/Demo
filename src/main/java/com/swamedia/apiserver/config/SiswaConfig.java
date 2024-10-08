package com.swamedia.apiserver.config;

import com.swamedia.apiserver.entity.SiswaEntity;
import com.swamedia.apiserver.repository.SiswaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SiswaConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            SiswaRepository repository){
        return args -> {
            SiswaEntity faris = new SiswaEntity(
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
