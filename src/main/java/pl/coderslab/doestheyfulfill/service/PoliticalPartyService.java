package pl.coderslab.doestheyfulfill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.doestheyfulfill.domain.PoliticalParty;
import pl.coderslab.doestheyfulfill.repository.PoliticalPartyRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PoliticalPartyService {
    private final PoliticalPartyRepository politicalPartyRepository;

    public void add(PoliticalParty politicalParty) {
        politicalPartyRepository.save(politicalParty);
    }

    public List<PoliticalParty> getPoliticiansParty() {
        return politicalPartyRepository.findAll();
    }

    public Optional<PoliticalParty> get(Long id) {
        return politicalPartyRepository.findById(id);
    }

    public void delete(Long id) {
        politicalPartyRepository.deleteById(id);
    }

    public void update(PoliticalParty politicalParty) {
        politicalPartyRepository.save(politicalParty);

    }
}

