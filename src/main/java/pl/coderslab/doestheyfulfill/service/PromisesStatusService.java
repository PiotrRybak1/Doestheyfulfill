package pl.coderslab.doestheyfulfill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.doestheyfulfill.domain.PromiseStatus;
import pl.coderslab.doestheyfulfill.repository.PromiseStatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromisesStatusService {
    private final PromiseStatusRepository promiseStatusRepository;

    public List<PromiseStatus> all (){
       return promiseStatusRepository.findAll();
    }


}
