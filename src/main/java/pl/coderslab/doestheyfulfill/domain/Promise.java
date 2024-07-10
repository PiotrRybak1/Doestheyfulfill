package pl.coderslab.doestheyfulfill.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Promise {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 600)
    private String titleOfPromise;
    @Size(max = 1200)
    private String descriptionOfThePromise;
    private Date dateOfThePromise;
    @ManyToOne
    @JoinColumn(name= "politician_id")
    private Politician politician;
    @ManyToOne
    @JoinColumn(name = "promise_status_id")
    private PromiseStatus promiseStatus;

    public Promise(String titleOfPromise, String descriptionOfThePromise, Politician politician) {
        this.titleOfPromise = titleOfPromise;
        this.descriptionOfThePromise = descriptionOfThePromise;
        this.politician = politician;
    }
}
