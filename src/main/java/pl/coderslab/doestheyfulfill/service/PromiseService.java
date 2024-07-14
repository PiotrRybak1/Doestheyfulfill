package pl.coderslab.doestheyfulfill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.doestheyfulfill.domain.PoliticalParty;
import pl.coderslab.doestheyfulfill.domain.Politician;
import pl.coderslab.doestheyfulfill.domain.Promise;
import pl.coderslab.doestheyfulfill.domain.PromiseStatus;
import pl.coderslab.doestheyfulfill.repository.PoliticalPartyRepository;
import pl.coderslab.doestheyfulfill.repository.PromiseRepository;
import pl.coderslab.doestheyfulfill.repository.PromiseStatusRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromiseService {
    private final PromiseRepository promiseRepository;


    public void add(Promise promise){
        promiseRepository.save(promise);
    }
    public List<Promise> getPromises() {
        return promiseRepository.findAll();
    }

    public Optional<Promise> get(Long id) {
        return promiseRepository.findById(id);
    }

    public void delete(Long id) {
        promiseRepository.deleteById(id);
    }
    public void update(Promise promise) {
        promiseRepository.save(promise);

    }
    public List<Promise> getSample(int numberOfPromise){
        return promiseRepository.findAllByDate(PageRequest.of(0,numberOfPromise));
    }
    public Set<Promise> politicianPromises(Politician politician){
        return promiseRepository.findAllByPolitician(politician);
    }

}

