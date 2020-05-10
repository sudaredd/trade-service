package app.trade.financialProductService;

import app.trade.config.ESConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@SpringBootApplication
@Import({ESConfig.class})
public class FinancialProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialProductServiceApplication.class, args);
	}

}
