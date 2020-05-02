package app.trade.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter@EqualsAndHashCode@ToString
public class Product {
    private String cusip;
    private String symbol;
    private String description;
    
}
