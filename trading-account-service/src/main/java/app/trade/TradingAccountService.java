package app.trade;

import app.trade.model.Book;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TradingAccountService {
    
    private Map<String , Book> booksCache =  new ConcurrentHashMap();
    
    @PostConstruct
    public void loadBooks() {
        booksCache.put("sudark",new Book("sudark", "SKB1", "Sudars Trading acccount"));
        booksCache.put("davidb",new Book("davidb", "DBB1", "davidb Trading acccount"));
        booksCache.put("innag",new Book("innag", "INB1", "inna Trading acccount"));
        booksCache.put("abdoa",new Book("abdoa", "abdoa", "abdoa Trading acccount"));
    }
    
    public Book book(String trader) {
        return booksCache.getOrDefault(trader, new Book());
    }
}
