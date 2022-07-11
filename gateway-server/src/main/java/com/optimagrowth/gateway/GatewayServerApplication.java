package com.optimagrowth.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication


// We could use @EnableDiscoveryClient which is a generic annotation from "spring-cloud-commons",
// and it takes the implementation from class path, since eureka is already in the classpath
// it takes @EnableEurekaClient which is in "spring-cloud-netflix" of spring, tied to a specific implementation
@EnableEurekaClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

}
