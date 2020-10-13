package com.github.slisowski.Spring_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SpringShopApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringShopApplication.class, args);
	}


	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
		validatingListener.addValidator("beforeCrate", validator());
		validatingListener.addValidator("beforeSave", validator());
	}

}
