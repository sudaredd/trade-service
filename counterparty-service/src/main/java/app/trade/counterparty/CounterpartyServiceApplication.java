package app.trade.counterparty;

import app.trade.config.ESConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@ImportAutoConfiguration(classes={ESConfig.class})
public class CounterpartyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterpartyServiceApplication.class, args);
	}

}
