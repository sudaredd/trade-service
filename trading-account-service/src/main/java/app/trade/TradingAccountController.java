package app.trade;

import app.trade.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tradingAccounts")
public class TradingAccountController {

    @Autowired
    private TradingAccountService tradingAccountService;
    
    @RequestMapping("{trader}")
    public Book getTradesById(@PathVariable("trader") String trader) {
        return tradingAccountService.book(trader);   
    }
    
}
