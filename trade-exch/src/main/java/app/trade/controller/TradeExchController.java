package app.trade.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trades")
public class TradeExchController {

    @RequestMapping("send/{tradeId}")
    public String getTradesById(@PathVariable("tradeId") String tradeId) {
        return "sent :" + tradeId;
    }
}
