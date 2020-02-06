package app.trade;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TradeReceiverStreams.class)
public class TradeProcessorConfig {
}
