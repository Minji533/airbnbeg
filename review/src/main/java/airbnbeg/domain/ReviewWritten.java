package airbnbeg.domain;

import airbnbeg.domain.*;
import airbnbeg.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewWritten extends AbstractEvent {

    private Long id;

    public ReviewWritten(Review aggregate) {
        super(aggregate);
    }

    public ReviewWritten() {
        super();
    }
}
//>>> DDD / Domain Event
