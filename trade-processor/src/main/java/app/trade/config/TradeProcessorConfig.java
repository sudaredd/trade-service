package app.trade.config;

import app.trade.TradeReceiverStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TradeReceiverStreams.class)
public class TradeProcessorConfig {
}
