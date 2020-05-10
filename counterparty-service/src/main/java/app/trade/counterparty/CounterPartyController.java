package app.trade.counterparty;

import app.trade.counterparty.processor.CounterPartyProcessor;
import app.trade.model.Audit;
import app.trade.service.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class CounterPartyController {

    private List<String> list = Arrays.asList("GS, MS, CS, MSSB, WF".split(","));

    @Autowired
    private CounterPartyProcessor counterPartyProcessor;

    @Value("${spring.application.name}")
    private String processName;

    @RequestMapping("counterParty")
    public String counterParty(@RequestHeader Map<String, String> headers) {
        String uniqueId = headers.get("UNIQUE_ID");
        counterPartyProcessor.process(new Audit(uniqueId, null, null, processName, Status.PRE_PROCESS));
        return list.get(new Random().nextInt(list.size()));
    }

}


