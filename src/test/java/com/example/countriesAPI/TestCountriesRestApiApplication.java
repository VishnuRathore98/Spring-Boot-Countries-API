package com.example.countriesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCountriesRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(CountriesRestApiApplication::main).with(TestCountriesRestApiApplication.class).run(args);
	}

}
