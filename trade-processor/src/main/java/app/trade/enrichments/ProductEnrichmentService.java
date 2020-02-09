package app.trade.enrichments;

import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("productEnrichmentService")
@Slf4j
public class ProductEnrichmentService implements EnrichmentService {
    @Override
    public void process(Trade trade) {
        log.info("Product Enrichment");
    }
}
