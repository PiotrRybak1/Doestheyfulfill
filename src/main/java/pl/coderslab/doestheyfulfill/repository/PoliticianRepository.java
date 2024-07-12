package pl.coderslab.doestheyfulfill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.doestheyfulfill.domain.Politician;

import java.util.Set;

public interface PoliticianRepository extends JpaRepository<Politician,Long> {
    @Query("select p from Politician p join fetch p.party t where t.id = :id" )
    Set<Politician> findPoliticianByPartyId(@Param("id") Long id);
}
