package app.trade;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TradeReceiverStreams {
    
    String TRADE_IN = "trade-in";
    
    @Input(TRADE_IN)
    MessageChannel tradeInBoundChannel();
}
