package airbnbeg.domain;

import airbnbeg.domain.*;
import airbnbeg.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RoomRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private String description;
    private Integer price;

    public RoomRegistered(Room aggregate) {
        super(aggregate);
    }

    public RoomRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
