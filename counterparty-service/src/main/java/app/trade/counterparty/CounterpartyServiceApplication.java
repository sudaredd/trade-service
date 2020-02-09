package app.trade.counterparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CounterpartyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterpartyServiceApplication.class, args);
	}

}
