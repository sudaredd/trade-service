package app.trade.productService;

import app.trade.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductServiceController {

    @Autowired
    private ProductService productService;

    @RequestMapping("{cusip}")
    public Product getProductByCusip(@PathVariable("cusip") String cusip) {
        return productService.product(cusip);
    }
}
