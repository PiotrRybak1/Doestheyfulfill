package pl.coderslab.doestheyfulfill.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
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
    @Size(max = 256)
    private String userName;
    @Email
    private String email;
    //it will be own annotation
    private String password;
    private boolean enabled;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Rating> rating = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Role> roles = new HashSet<>();

    public User(String userName, String email, String password, boolean enabled) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

}

