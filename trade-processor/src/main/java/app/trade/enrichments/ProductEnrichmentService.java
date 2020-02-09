package app.trade.enrichments;

import app.trade.model.Product;
import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("productEnrichmentService")
@Slf4j
public class ProductEnrichmentService implements EnrichmentService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void process(Trade trade) {
        log.info("Product Enrichment");

        Product product = restTemplate.getForObject("http://product-service/product/" + trade.getCusip(), Product.class);
        log.info("got a product :" + product);
        trade.setSymbol(product.getSymbol());
    }
}
