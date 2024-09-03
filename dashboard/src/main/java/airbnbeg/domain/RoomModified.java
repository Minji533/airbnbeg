package airbnbeg.domain;

import airbnbeg.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RoomModified extends AbstractEvent {

    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String status;
}
