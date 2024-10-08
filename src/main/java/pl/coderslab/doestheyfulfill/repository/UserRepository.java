package pl.coderslab.doestheyfulfill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.doestheyfulfill.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findUserByUserName(String username);

}