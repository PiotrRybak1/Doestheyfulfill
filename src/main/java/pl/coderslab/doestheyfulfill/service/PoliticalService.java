package pl.coderslab.doestheyfulfill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.doestheyfulfill.domain.Politician;
import pl.coderslab.doestheyfulfill.repository.PoliticianRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PoliticalService {
    private final PoliticianRepository politicsRepository;

    public void add(Politician politician){
        politicsRepository.save(politician);
    }
    public List<Politician> getPoliticians() {
        return politicsRepository.findAll();
    }

    public Optional<Politician> get(Long id) {
        return politicsRepository.findById(id);
    }

    public void delete(Long id) {
        politicsRepository.deleteById(id);
    }
    public void update(Politician politician) {
    politicsRepository.save(politician);

    }
}

