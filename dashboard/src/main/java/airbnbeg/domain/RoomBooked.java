package airbnbeg.domain;

import airbnbeg.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RoomBooked extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long roomId;
    private String payId;
    private Date date;
    private String status;
    private Integer price;
}
