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
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RoomBooked'"
    )
    public void wheneverRoomBooked_Payment(@Payload RoomBooked roomBooked) {
        RoomBooked event = roomBooked;
        System.out.println(
            "\n\n##### listener Payment : " + roomBooked + "\n\n"
        );

        // Sample Logic //
        Payment.payment(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
