package com.example.currencycalculationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients("com.example.currencycalculationservice")
public class CurrencyCalculationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalculationServiceApplication.class, args);
	}

}
