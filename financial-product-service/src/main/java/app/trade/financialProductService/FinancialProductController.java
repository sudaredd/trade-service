package app.trade.financialProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class FinancialProductController {

    private List<Double> list = Arrays.asList(10.21, 3.76, 1000.234, 765.33, 98.76);

    @RequestMapping("accruedInterest")
    public double accruedInterest() {
        return list.get(new Random().nextInt(list.size()));
    }
}
