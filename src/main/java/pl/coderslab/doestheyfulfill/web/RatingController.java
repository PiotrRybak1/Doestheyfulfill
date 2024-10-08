package pl.coderslab.doestheyfulfill.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.doestheyfulfill.domain.Promise;
import pl.coderslab.doestheyfulfill.domain.Rating;
import pl.coderslab.doestheyfulfill.domain.User;
import pl.coderslab.doestheyfulfill.service.PromiseService;
import pl.coderslab.doestheyfulfill.service.RatingService;
import pl.coderslab.doestheyfulfill.service.UserService;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;
    private final PromiseService promiseService;
    private final UserService userService;

    @GetMapping("/all")
    public String allRatings(Model model){
        model.addAttribute("ratingsAll", ratingService.getRatings());
        return "ratingsList";
    }

    @GetMapping("/{id}")
    public String getDetails(@PathVariable Long id, Model model){
        Optional<Rating> optionalRating = ratingService.get(id);
        if(optionalRating.isPresent()){
            model.addAttribute("ratingDetails", optionalRating.get());
            return "detailsRating";
        }
        else return "redirect:/promise/all";

    }

    @GetMapping("/add/{id}")
    public String addRating(@PathVariable Long id, Model model) {
        Optional<Promise> optionalPromise = promiseService.get(id);
        if(optionalPromise.isEmpty()){
            return "redirect:/promise/all";
        }
        Rating rating = new Rating();
        User user  = userService.getCurrentUser();
        rating.setPromise(optionalPromise.get());
        rating.setUser(user);
        model.addAttribute("addRating", rating);
        return "ratingForm";
    }

    @PostMapping("/add")
    public String addRating(@Valid @ModelAttribute("addRating") Rating rating, BindingResult result) {
        if (result.hasErrors()) {
            return "ratingForm";
        }
        ratingService.add(rating);
        return "redirect:/promise/all";
    }
    @GetMapping("/edit/{id}")
    public String editPromise(@PathVariable Long id, Model model){
        Optional<Rating> optionalRatingEdit = ratingService.get(id);
        if(optionalRatingEdit.isPresent()){
            model.addAttribute("ratingForEdit", optionalRatingEdit.get());
            return "editRating";
        }
        else return "redirect:/rating/all";
    }
    @PostMapping("/edit")
    public String editRating(@ModelAttribute("ratingForEdit") @Valid Rating rating , BindingResult result){
        if(result.hasErrors()){
            return "editRating";
        }
        ratingService.update(rating);
        return "redirect:/rating/all";
    }
    @GetMapping("/remove/{id}")
    public String removeRating(@PathVariable Long id){
        ratingService.delete(id);
        return "redirect:/rating/all";
    }
}
