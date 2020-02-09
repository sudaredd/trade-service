package app.trade.enrichments;

import app.trade.model.Trade;

public interface EnrichmentService {
    void process(Trade trade);
}
