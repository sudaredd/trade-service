package app.trade;

import app.trade.exch.TradeSenderStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TradeSenderStreams.class)
public class TradeExchConfig {
}
