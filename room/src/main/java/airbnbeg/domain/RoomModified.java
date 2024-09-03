package airbnbeg.domain;

import airbnbeg.domain.*;
import airbnbeg.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RoomModified extends AbstractEvent {

    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String status;

    public RoomModified(Room aggregate) {
        super(aggregate);
    }

    public RoomModified() {
        super();
    }
}
//>>> DDD / Domain Event
