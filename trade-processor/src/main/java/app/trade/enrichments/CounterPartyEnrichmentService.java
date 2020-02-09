package app.trade.enrichments;

import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("counterPartyEnrichmentService")
@Slf4j
public class CounterPartyEnrichmentService implements EnrichmentService{

    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public void process(Trade trade) {
        log.info("Applying counterparty Enrichment");
        String counterParty = restTemplate.getForObject("http://counterparty-service/counterParty", String.class);
        trade.setCounterParty(counterParty);
    }
}
