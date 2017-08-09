package com.muhammadthahir.Selemene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SelemeneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelemeneApplication.class, args);
	}
}
