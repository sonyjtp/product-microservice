package com.myretail.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProductApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductApp.class, args);
	}
}
