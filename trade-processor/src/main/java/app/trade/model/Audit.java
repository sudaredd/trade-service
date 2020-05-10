package app.trade.model;

import app.trade.service.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Audit {
    @Id
    private String uniqueId;
    private Trade trade;
    @Setter
    private String time;
    private String processName;
    @Setter
    private Status status;
}
