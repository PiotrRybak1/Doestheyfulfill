package pl.coderslab.doestheyfulfill.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "politicialPartys")
@Entity
@ToString
public class PoliticalParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max =256)
    private String name;
    @Size(max = 600)
    private String description;
    @OneToMany(mappedBy = "party")
    @ToString.Exclude
    private Set<Politician> politician;

    public PoliticalParty(String name, String description) {
        this.name = name;
        this.description = description;

    }
}
