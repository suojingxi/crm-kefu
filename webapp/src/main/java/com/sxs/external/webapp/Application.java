package com.sxs.external.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.sxs.external.dao.datasource.DynamicDataSourceRegister;

@SpringBootApplication
@ComponentScan("com.sxs.external")
@EnableAutoConfiguration
@Import(DynamicDataSourceRegister.class)
public class Application {

	//启动spring boot的入口
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
