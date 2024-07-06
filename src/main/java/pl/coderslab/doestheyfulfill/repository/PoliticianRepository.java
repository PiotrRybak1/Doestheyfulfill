package pl.coderslab.doestheyfulfill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.doestheyfulfill.domain.Politician;

public interface PoliticianRepository extends JpaRepository<Politician,Long> {
}
