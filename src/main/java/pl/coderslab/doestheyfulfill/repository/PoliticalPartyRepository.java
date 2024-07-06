package pl.coderslab.doestheyfulfill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.doestheyfulfill.domain.PoliticalParty;

public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {
}
