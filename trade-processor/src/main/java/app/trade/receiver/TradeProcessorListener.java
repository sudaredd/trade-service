package app.trade.receiver;

import app.trade.TradeTransformer;
import app.trade.enrichments.EnrichmentService;
import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TradeProcessorListener {

    @Autowired
    private TradeTransformer tradeTransformer;
    
    @Autowired
    private List<EnrichmentService> enrichmentServices;
    
    @StreamListener("trade-in")
    public void onMessage(@Payload String str) {
        log.info("in stream subscriber :"+str);
        Trade trade = tradeTransformer.trade(str);
        enrichmentServices.forEach(a->a.process(trade));

        String output = tradeTransformer.convertToNewTrade(trade);
        log.info("out going message:"+output);
    }

}
