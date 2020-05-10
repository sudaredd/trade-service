package app.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@SpringBootApplication
public class TradingAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingAccountServiceApplication.class, args);
	}

}
