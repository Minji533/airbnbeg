package airbnbeg.domain;

import airbnbeg.ReservationApplication;
import airbnbeg.domain.BookingCancelled;
import airbnbeg.domain.RoomBooked;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private Long roomId;

    private String payId;

    private Date date;

    private String status;

    private Integer price;

    @PostPersist
    public void onPostPersist() {
        RoomBooked roomBooked = new RoomBooked(this);
        roomBooked.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        BookingCancelled bookingCancelled = new BookingCancelled(this);
        bookingCancelled.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }

    //<<< Clean Arch / Port Method
    public void cancelBooking() {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
