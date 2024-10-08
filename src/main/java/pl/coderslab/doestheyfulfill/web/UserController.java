package pl.coderslab.doestheyfulfill.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.doestheyfulfill.domain.Rating;
import pl.coderslab.doestheyfulfill.domain.User;
import pl.coderslab.doestheyfulfill.repository.RoleRepository;
import pl.coderslab.doestheyfulfill.service.RatingService;
import pl.coderslab.doestheyfulfill.service.UserService;

import java.util.Set;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final RatingService ratingService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        userService.add(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/show")
    public String userRatings(Model model) {
        Set<Rating> currentUserRatings = ratingService.userRatings(userService.getCurrentUser());
        model.addAttribute("currentUserRatings", currentUserRatings);
        return "currentUserRatings";

    }

}




