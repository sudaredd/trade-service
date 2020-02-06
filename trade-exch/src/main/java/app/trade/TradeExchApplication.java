package app.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TradeExchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeExchApplication.class, args);
    }

}
