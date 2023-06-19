package com.comibomrestaurante;

import com.comibomrestaurante.controller.ClienteController;
import com.comibomrestaurante.service.ClienteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ComibomRestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComibomRestauranteApplication.class, args);
	}

}
