package app.trade.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TradeReceiver {

    @StreamListener("trade-in")
    public void onMessage(@Payload String str) {
        log.info("in stream subscriber :"+str);
    }

}
