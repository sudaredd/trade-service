package app.trade.model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Builder
@XmlRootElement(name = "NewTrade")
@XmlAccessorType(XmlAccessType.FIELD)
public class Trade {
    @XmlElement(name = "TradeId")
    private String tradeId;
    
    @XmlElement(name="TradingAccount")
    private String account;
    
    @XmlElement(name = "Trader")
    private String trader;   
    
    @XmlElement(name = "TradingAccount")
    private String tradingAccount; 
    
    @XmlElement(name = "counterParty")
    private String counterParty;
    
    @XmlElement(name = "Quantity")
    private int quantity;
    
    @XmlElement(name = "Price")
    private double price;
    
    @XmlElement(name = "Side")
    private String side;
    
    @XmlElement(name = "Symbol")
    private String symbol;
    
    @XmlElement(name = "SettlementDate")
    private String settleDate;
    
    @XmlElement(name = "TradeDate")
    private String tradeDate;
    
    @XmlElement(name = "TradeTime")
    private String tradeTime;
}
