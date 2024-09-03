package airbnbeg.domain;

import airbnbeg.ReviewApplication;
import airbnbeg.domain.ReviewWritten;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long roomId;

    private String contetn;

    @PostPersist
    public void onPostPersist() {
        ReviewWritten reviewWritten = new ReviewWritten(this);
        reviewWritten.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }
}
//>>> DDD / Aggregate Root
