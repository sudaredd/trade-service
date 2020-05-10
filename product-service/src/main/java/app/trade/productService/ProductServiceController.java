package app.trade.productService;

import app.trade.model.Audit;
import app.trade.model.Product;
import app.trade.service.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductServiceController {

    @Autowired
    private ProductService productService;

    @Value("${spring.application.name}")
    private String processName;

    @RequestMapping("{cusip}")
    public Product getProductByCusip(@RequestHeader Map<String, String> headers, @PathVariable("cusip") String cusip) {
        String uniqueId = headers.get("UNIQUE_ID");
        productService.process(new Audit(uniqueId, null, null, processName, Status.PRE_PROCESS));
        return productService.product(cusip);
    }
}
