package airbnbeg.infra;

import airbnbeg.config.kafka.KafkaProcessor;
import airbnbeg.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ViewPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ViewPageRepository viewPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomRegistered_then_CREATE_1(
        @Payload RoomRegistered roomRegistered
    ) {
        try {
            if (!roomRegistered.validate()) return;

            // view 객체 생성
            ViewPage viewPage = new ViewPage();
            // view 객체에 이벤트의 Value 를 set 함
            viewPage.setId(roomRegistered.getId());
            viewPage.setName(roomRegistered.getName());
            viewPage.setDescription(roomRegistered.getDescription());
            viewPage.setPrice(roomRegistered.getPrice());
            viewPage.setRoomStatus(active);
            // view 레파지 토리에 save
            viewPageRepository.save(viewPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomModified_then_UPDATE_1(
        @Payload RoomModified roomModified
    ) {
        try {
            if (!roomModified.validate()) return;
            // view 객체 조회
            Optional<ViewPage> viewPageOptional = viewPageRepository.findById(
                roomModified.getId()
            );

            if (viewPageOptional.isPresent()) {
                ViewPage viewPage = viewPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewPage.setName(roomModified.getName());
                viewPage.setDescription(roomModified.getDescription());
                viewPage.setPrice(roomModified.getPrice());
                // view 레파지 토리에 save
                viewPageRepository.save(viewPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomDeleted_then_UPDATE_2(
        @Payload RoomDeleted roomDeleted
    ) {
        try {
            if (!roomDeleted.validate()) return;
            // view 객체 조회
            Optional<ViewPage> viewPageOptional = viewPageRepository.findById(
                roomDeleted.getId()
            );

            if (viewPageOptional.isPresent()) {
                ViewPage viewPage = viewPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewPage.setRoomStatus(deleted);
                // view 레파지 토리에 save
                viewPageRepository.save(viewPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomBooked_then_UPDATE_3(@Payload RoomBooked roomBooked) {
        try {
            if (!roomBooked.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookingCancelled_then_UPDATE_4(
        @Payload BookingCancelled bookingCancelled
    ) {
        try {
            if (!bookingCancelled.validate()) return;
            // view 객체 조회
            Optional<ViewPage> viewPageOptional = viewPageRepository.findById(
                bookingCancelled.getId()
            );

            if (viewPageOptional.isPresent()) {
                ViewPage viewPage = viewPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewPage.setReservationStatus(cancelled);
                // view 레파지 토리에 save
                viewPageRepository.save(viewPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
