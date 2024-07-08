package com.aftermidnight.speleohub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aftermidnight.speleohub.core.CustomBanner;

@SpringBootApplication
public class SpeleohubApplication {

	private static ApplicationContext APPLICATION_CONTEXT;
	private static SpringApplication APPLICATION;
	
	public static void main(String[] args) {
		APPLICATION = new SpringApplication(SpeleohubApplication.class);
		APPLICATION.setBanner(new CustomBanner());
		APPLICATION_CONTEXT = APPLICATION.run(args);
	}

	public static <T> T getBean(Class<T> requiredType) {
		return APPLICATION_CONTEXT.getBean(requiredType);
	}

	//https://www.baeldung.com/role-and-privilege-for-spring-security-registration

}
