package app.trade;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class TradeExchApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TradeExchApplication.class, args);
        new SpringApplicationBuilder()
                .sources(TradeExchApplication.class)
                .web(WebApplicationType.NONE).build().run(args);
    }

}
