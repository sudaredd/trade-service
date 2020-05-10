package app.trade.enrichments;

import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Service("counterPartyEnrichmentService")
@Slf4j
public class CounterPartyEnrichmentService implements EnrichmentService{

    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public void process(Trade trade) {
        log.info("Applying counterparty Enrichment");
        HttpEntity<String> entity = getStringHttpEntity(trade);
        ResponseEntity<String> res = restTemplate.exchange("http://counterparty-service/counterParty", HttpMethod.GET, entity, String.class);
        String counterParty = res.getBody();
        trade.setCounterParty(counterParty);
    }


}
