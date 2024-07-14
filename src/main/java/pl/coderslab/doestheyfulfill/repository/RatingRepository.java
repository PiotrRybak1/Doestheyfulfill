package pl.coderslab.doestheyfulfill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.doestheyfulfill.domain.Rating;
import pl.coderslab.doestheyfulfill.domain.User;

import java.util.Set;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Set<Rating> findAllByUser(User user);
}