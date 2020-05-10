package app.trade.financialProductService;

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
public class FinancialProductController {

    private List<Double> list = Arrays.asList(10.21, 3.76, 1000.234, 765.33, 98.76);

    @Value("${spring.application.name}")
    private String processName;

    @Autowired
    private FinanicialProductProcessor finanicialProductProcessor;

    @RequestMapping("accruedInterest")
    public double accruedInterest(@RequestHeader Map<String, String> headers) {
        String uniqueId = headers.get("UNIQUE_ID");
        finanicialProductProcessor.process(new Audit(uniqueId, null, null, processName, Status.PRE_PROCESS));
        return list.get(new Random().nextInt(list.size()));
    }
}
