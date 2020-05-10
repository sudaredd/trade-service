package app.trade.enrichments;

import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("financialProductEnrichmentService")
@Slf4j
public class FinancialProductEnrichmentService implements EnrichmentService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void process(Trade trade) {
        log.info("Financial Product Enrichment");
        HttpEntity<String> entity = getStringHttpEntity(trade);
        Double accruedInterest = restTemplate.exchange("http://financial-product-service/accruedInterest", HttpMethod.GET, entity,Double.class).getBody();
        trade.setAccruedInterest(accruedInterest);
    }
}
