package app.trade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Builder
public class Trade {
    private String tradeId;
    private String accout;
    private int quantity;
    private double price;
    private String side;
    private String symbol;
}
