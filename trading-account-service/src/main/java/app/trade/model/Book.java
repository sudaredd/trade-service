package app.trade.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Book {
    private String traderId;
    private String bookId;
    private String bookDescription;
}
