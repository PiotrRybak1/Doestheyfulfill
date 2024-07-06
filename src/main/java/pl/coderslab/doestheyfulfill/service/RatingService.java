package pl.coderslab.doestheyfulfill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.doestheyfulfill.domain.PoliticalParty;
import pl.coderslab.doestheyfulfill.domain.Rating;
import pl.coderslab.doestheyfulfill.repository.RatingRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public void add(Rating rating){
        ratingRepository.save(rating);
    }
    public List<Rating> getPoliticians() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> get(Long id) {
        return ratingRepository.findById(id);
    }

    public void delete(Long id) {
        ratingRepository.deleteById(id);
    }
    public void update(Rating rating) {
        ratingRepository.save(rating);

    }
}
