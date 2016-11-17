package com.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class SpringDataElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataElasticApplication.class, args);
	}
}
