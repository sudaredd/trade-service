package app.trade;

import app.trade.enrichments.EnrichmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class TradeProcessorApplication {

    @Autowired
    @Qualifier("productEnrichmentService")
    private EnrichmentService productEnrichmentService;
    
    @Autowired
    @Qualifier("tradingAccountEnrichmentService")
    private EnrichmentService tradingAccountEnrichmentService;
     
    @Autowired
    @Qualifier("financialProductEnrichmentService")
    private EnrichmentService financialProductEnrichmentService;
     
    @Autowired
    @Qualifier("counterPartyEnrichmentService")
    private EnrichmentService counterPartyEnrichmentService;
    
    
    @Bean(name = "enrichmentServices")
    List<EnrichmentService> enrichmentServices() {
        return Arrays.asList(counterPartyEnrichmentService, tradingAccountEnrichmentService, 
                productEnrichmentService, financialProductEnrichmentService);
    }
    
    @Bean
    @LoadBalanced
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
