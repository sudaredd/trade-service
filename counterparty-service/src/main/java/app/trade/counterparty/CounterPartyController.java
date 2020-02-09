package app.trade.counterparty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class CounterPartyController {

    private List<String> list = Arrays.asList("GS, MS, CS, MSSB, WF".split(","));

    @RequestMapping("counterParty")
    public String counterParty() {
        return list.get(new Random().nextInt(list.size()));
    }

}


