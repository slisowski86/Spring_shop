package com.github.slisowski.Spring_shop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;


@SpringBootApplication
public class SpringShopApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringShopApplication.class, args);
	}


	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}


	}

