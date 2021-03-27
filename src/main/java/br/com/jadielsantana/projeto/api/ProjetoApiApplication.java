package br.com.jadielsantana.projeto.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.jadielsantana.projeto.api")
@EntityScan(basePackages = "br.com.jadielsantana.projeto.api.model")
public class ProjetoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApiApplication.class, args);
	}

}
