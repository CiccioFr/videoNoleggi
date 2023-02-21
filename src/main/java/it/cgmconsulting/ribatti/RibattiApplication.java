package it.cgmconsulting.ribatti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class RibattiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibattiApplication.class, args);
	}

}
