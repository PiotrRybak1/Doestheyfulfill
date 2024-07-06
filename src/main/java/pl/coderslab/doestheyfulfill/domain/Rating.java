package pl.coderslab.doestheyfulfill.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings")
@ToString
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(0)
    @Max(5)
    private  int rate;
    @Size( max = 600)
    private String comment;
    private LocalDateTime assessmentDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn (name = "promise_id")
    private Promise promise;

    public Rating(int rate, String comment, User user, Promise promise) {
        this.rate = rate;
        this.comment = comment;
        this.user = user;
        this.promise = promise;
    }

    @PrePersist
    public void prePersist() {
        assessmentDate = LocalDateTime.now();
    }

}
