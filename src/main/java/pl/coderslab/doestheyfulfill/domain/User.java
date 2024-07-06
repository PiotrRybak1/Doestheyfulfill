package pl.coderslab.doestheyfulfill.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max =256)
    private String firsName;
    @Size(max =256)
    private String lastName;
    private LocalDate dateOfBirth;
    @Email
    private String email;
    //it will be own annotation
    private String password;
    //admin or user
    private boolean userRole;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Rating > rating = new HashSet<>();

    public User(String firsName, String lastName, int year, int month, int day, String email, String password, boolean userRole) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }
}
