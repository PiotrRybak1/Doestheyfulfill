package pl.coderslab.doestheyfulfill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.doestheyfulfill.domain.Promise;

public interface PromiseRepository extends JpaRepository<Promise,Long> {
}
