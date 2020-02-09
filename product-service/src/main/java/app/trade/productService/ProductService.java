package app.trade.productService;

import app.trade.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class ProductService {

    private Map<String , Product> productsCache  = new ConcurrentHashMap<>();
    private Product dummyProduct = new Product();
    
    @PostConstruct
    public void init() {
        productsCache.put("9128284J6", new Product("9128284J6", "ED", "Euro doller"));
        productsCache.put("9128284P2", new Product("9128284P2", "ES", "S&P 500"));
        productsCache.put("9128284L1", new Product("9128284L1", "C", "Corn"));
        productsCache.put("9128284M9", new Product("9128284M9", "S", "Soya"));
        productsCache.put("9128284N7", new Product("9128284N7", "MS", "Morgan St"));
    }
    
    public Product product(String cusip) {
        return productsCache.getOrDefault(cusip, dummyProduct);
    }
}
