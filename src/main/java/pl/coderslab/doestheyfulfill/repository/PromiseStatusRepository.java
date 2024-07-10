package pl.coderslab.doestheyfulfill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.doestheyfulfill.domain.PromiseStatus;

import java.util.List;

public interface PromiseStatusRepository extends JpaRepository<PromiseStatus, Long> {
    List<PromiseStatus.Name> findByName(PromiseStatus.Name name);
}
