package pl.coderslab.doestheyfulfill.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.doestheyfulfill.service.PromiseService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Hello {
    private final PromiseService promiseService;

    @GetMapping("/")
    public String homePage(Model model){
            model.addAttribute("latestPromise", promiseService.getSample(5));
            return "HomePage";
        }
}
