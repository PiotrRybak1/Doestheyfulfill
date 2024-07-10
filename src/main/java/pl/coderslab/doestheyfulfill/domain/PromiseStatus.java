package pl.coderslab.doestheyfulfill.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name ="promise_status" )
public class PromiseStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private PromiseStatus.Name name;

    public PromiseStatus(Name name) {
        this.name = name;
    }

    public enum Name {
        PROMISE_MADE,
        IN_PROGRESS,
        COMPLETED,
        NOT_IMPLEMENTED,
    }
}
