package pl.coderslab.doestheyfulfill.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
@Entity
public class Promise {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 600)
    private String titleOfPromise;
    @Size(max = 1200)
    private String descriptionOfThePromise;
    private LocalDate dateOfThePromise;
    @Size(max= 256)
    private String promiseStatus;
    @ManyToOne
    @JoinColumn(name= "politician_id")
    private Politician politician;

}
