package app.trade.financialProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FinancialProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialProductServiceApplication.class, args);
	}

}
