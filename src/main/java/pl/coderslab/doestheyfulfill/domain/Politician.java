package pl.coderslab.doestheyfulfill.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "politicians")

@Entity
public class Politician {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Size(max = 256)
  private String firstName;
  @Size(max = 256)
  private String lastName;
  private LocalDate dayOfBirth;
  @Size(max = 256)
  private String position;

  @ManyToOne
  @JoinColumn(name = "party_id")
  private PoliticalParty party;

  @OneToMany(mappedBy = "politician")
  @ToString.Exclude
  private Set<Promise> promises = new HashSet<>();

  public Politician(String firstName, String lastName, int year, int month, int day, String position, PoliticalParty party) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dayOfBirth = LocalDate.of(year,month,day);
    this.position = position;
    this.party = party;
  }
}
