package app.trade;

import app.trade.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("tradingAccounts")
public class TradingAccountController {

    @Autowired
    private TradingAccountService tradingAccountService;

    @Value("${spring.application.name}")
    private String processName;

    @RequestMapping("{trader}")
    public Book getTradesById(@RequestHeader Map<String, String> headers, @PathVariable("trader") String trader) {
        String uniqueId = headers.get("UNIQUE_ID");
//        tradingAccountService.process(new Audit(uniqueId, null, null, processName, Status.PRE_PROCESS));
        return tradingAccountService.book(trader);
    }

}
