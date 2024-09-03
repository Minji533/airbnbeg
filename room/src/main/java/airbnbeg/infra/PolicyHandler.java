package airbnbeg.infra;

import airbnbeg.config.kafka.KafkaProcessor;
import airbnbeg.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RoomRepository roomRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RoomBooked'"
    )
    public void wheneverRoomBooked_SendConfirmationMessage(
        @Payload RoomBooked roomBooked
    ) {
        RoomBooked event = roomBooked;
        System.out.println(
            "\n\n##### listener SendConfirmationMessage : " +
            roomBooked +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookingCancelled'"
    )
    public void wheneverBookingCancelled_SendCancelledMessage(
        @Payload BookingCancelled bookingCancelled
    ) {
        BookingCancelled event = bookingCancelled;
        System.out.println(
            "\n\n##### listener SendCancelledMessage : " +
            bookingCancelled +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
