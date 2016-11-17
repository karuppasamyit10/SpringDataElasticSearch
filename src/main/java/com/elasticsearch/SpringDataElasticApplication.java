package com.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@SpringBootApplication
//@EnableJpaRepositories("com.elasticsearch.jpa.repository")
//@EnableElasticsearchRepositories("com.elasticsearch.elastic.repository")
public class SpringDataElasticApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataElasticApplication.class, args);
	}
	
	 @Override 
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SpringDataElasticApplication.class);
	    }

}
