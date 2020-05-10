package app.trade.receiver;

import app.trade.TradeTransformer;
import app.trade.enrichments.EnrichmentService;
import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TradeProcessorListener {

    @Autowired
    private TradeTransformer tradeTransformer;
    
    @Autowired
    private List<EnrichmentService> enrichmentServices;
    
    @StreamListener("trade-in")
    public void onMessage(@Headers MessageHeaders headers, @Payload String str) {
        String uniqueId = (String) headers.get("UNIQUE_ID");
        log.info("in stream subscriber :"+str);
        Trade trade = tradeTransformer.trade(str);
        trade.setUniqueId(uniqueId);
        enrichmentServices.parallelStream().forEach(a->a.process(trade));

        String output = tradeTransformer.convertToNewTrade(trade);
        log.info("out going message:"+output);
    }

}
