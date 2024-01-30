/*
@author :: Abhishek Gaurav
*/

package com.mockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.mockito.*")
@SpringBootApplication
public class MockitoFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoFrameworkApplication.class, args);
	}

}
