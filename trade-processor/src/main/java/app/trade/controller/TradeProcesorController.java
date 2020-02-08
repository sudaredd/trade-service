package app.trade.controller;

import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("trades")
public class TradeProcesorController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;
    

    @RequestMapping("/all")
    public List<Trade> getAllTrades() {
        Trade t1 = Trade.builder().tradeId("T1").account("A1").side("Buy").quantity(100).price(100.25).build();
        Trade t2 = Trade.builder().tradeId("T2").account("a2").side("Buy").quantity(90).price(100.12).build();
        Trade t3 = Trade.builder().tradeId("T3").account("A3").side("Buy").quantity(10).price(1.43).build();
        Trade t4 = Trade.builder().tradeId("T4").account("A4").side("Buy").quantity(1000).price(10.125).build();
        return Arrays.asList(t1, t2, t3, t4);
    }
    
    @RequestMapping("byTradeId/{tradeId}")
    public List<Trade> getTradesById(@PathVariable ("tradeId") String tradeId) {

        Trade t1 = Trade.builder().tradeId("T1").account("A1").side("Buy").quantity(100).price(100.25).build();
        Trade t2 = Trade.builder().tradeId("T2").account("a2").side("Buy").quantity(90).price(100.12).build();
        return Arrays.asList(t1, t2);
    }


}
