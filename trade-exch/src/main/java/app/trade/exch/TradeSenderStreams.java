package app.trade.exch;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TradeSenderStreams {
    
    String TRADE_OUT = "trade-out";
    
    @Output(TRADE_OUT)
    MessageChannel tradeOutBoundChannel();
}
