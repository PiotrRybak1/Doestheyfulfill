package pl.coderslab.doestheyfulfill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.doestheyfulfill.domain.PoliticalParty;
import pl.coderslab.doestheyfulfill.domain.Promise;
import pl.coderslab.doestheyfulfill.repository.PoliticalPartyRepository;
import pl.coderslab.doestheyfulfill.repository.PromiseRepository;

import java.util.List;
import java.util.Optional;
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
}

