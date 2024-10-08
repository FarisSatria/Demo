package com.swamedia.apiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.swamedia.apiserver", "com.swamedia.apiserver.config", "com.swamedia.apiserver.controller", "com.swamedia.apiserver.service"})
@EnableJpaRepositories(basePackages = "com.swamedia.apiserver.repository")
@EntityScan(basePackages = "com.swamedia.apiserver.entity")
public class ApiServer {

	public static void main(String[] args) {
		SpringApplication.run(ApiServer.class, args);
	}

}
