package com.spring.hellospring;

import com.spring.tutorialspoint.model.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
	@Bean
	public HelloWorld helloworld() {
		return new HelloWorld();

	}
}
