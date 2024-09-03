package airbnbeg.domain;

import airbnbeg.domain.*;
import airbnbeg.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RoomBooked extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long roomId;
    private String payId;
    private Date date;
    private String status;
    private Integer price;

    public RoomBooked(Reservation aggregate) {
        super(aggregate);
    }

    public RoomBooked() {
        super();
    }
}
//>>> DDD / Domain Event
