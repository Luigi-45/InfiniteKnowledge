package com.InfiniteKnowledge.RegistrosReportes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RegistrosReportesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrosReportesApplication.class, args);
	}

}
