package pl.coderslab.doestheyfulfill.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.doestheyfulfill.domain.Politician;
import pl.coderslab.doestheyfulfill.domain.Promise;

import java.util.List;
import java.util.Set;

public interface PromiseRepository extends JpaRepository<Promise, Long> {
    @Query("select p from Promise p order by p.dateOfThePromise desc")
    List<Promise> findAllByDate(Pageable pageable);

    Set<Promise> findAllByPolitician(Politician politician);
}
