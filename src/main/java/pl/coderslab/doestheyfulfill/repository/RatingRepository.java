package pl.coderslab.doestheyfulfill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.doestheyfulfill.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}