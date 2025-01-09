package com.roque.teste.act.api_busca_cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.roque.teste.act.api_busca_cep.*")
public class ApiBuscaCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBuscaCepApplication.class, args);
	}

}
