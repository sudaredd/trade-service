package app.trade.enrichments;

import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        Double accruedInterest = restTemplate.getForObject("http://financial-product-service/accruedInterest", Double.class);
        trade.setAccruedInterest(accruedInterest);
    }
}
