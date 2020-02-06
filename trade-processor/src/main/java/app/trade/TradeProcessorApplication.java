package app.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@EnableEurekaClient
@SpringBootApplication
public class TradeProcessorApplication {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
	WebClient.Builder webClientBuilder() {
    	return WebClient.builder();
	}

    public static void main(String[] args) {
        SpringApplication.run(TradeProcessorApplication.class, args);
    }

}
