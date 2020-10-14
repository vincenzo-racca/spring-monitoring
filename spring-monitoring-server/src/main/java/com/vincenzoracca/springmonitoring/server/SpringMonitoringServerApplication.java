package com.vincenzoracca.springmonitoring.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringMonitoringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMonitoringServerApplication.class, args);
	}

}
