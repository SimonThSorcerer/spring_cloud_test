package com.springcloudtest.springcloudtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTestApplication.class, args);
	}

}
