package com.nishant.newsportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.nishant.newsportal.model")
@EnableJpaRepositories("com.nishant.newsportal.repository")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class NewsportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsportalApplication.class, args);
	}

}
