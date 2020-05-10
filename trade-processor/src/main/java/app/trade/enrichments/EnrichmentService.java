package app.trade.enrichments;

import app.trade.model.Trade;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public interface EnrichmentService {
    void process(Trade trade);
    default HttpEntity<String> getStringHttpEntity(Trade trade) {
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.set("UNIQUE_ID", trade.getUniqueId());
        return new HttpEntity<String>("parameters", httpHeaders);
    }
}
