package app.trade.enrichments;

import app.trade.model.Book;
import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service("tradingAccountEnrichmentService")
@Slf4j
public class TradingAccountEnrichmentService implements EnrichmentService{
   
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;
    
    @Override
    public void process(Trade trade) {
        log.info("Trading account Enrichment");

/*      Book book = webClientBuilder.build()
                .get()
                .uri("http://trading-account-service/tradingAccounts/"+trade.getTrader())
                .retrieve()
                .bodyToMono(Book.class)
                .block();*/
 
//        Movie movie =  restTemplate.getForObject("http://localhost:8081/movieInfo/"+rating.getId(), Movie.class);
        
      Book  book =   restTemplate.getForObject("http://trading-account-service/tradingAccounts/"+trade.getTrader(), Book.class);
        log.info("got book :"+book);
        trade.setTradingAccount(book.getBookId());
    }
}
