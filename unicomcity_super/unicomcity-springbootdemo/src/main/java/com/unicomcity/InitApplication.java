package com.unicomcity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.unicomcity.*.mapper"})
public class InitApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitApplication.class, args);
	}
}
