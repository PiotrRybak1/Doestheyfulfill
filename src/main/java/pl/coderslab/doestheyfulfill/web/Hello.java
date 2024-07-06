package pl.coderslab.doestheyfulfill.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.doestheyfulfill.domain.Politician;
import pl.coderslab.doestheyfulfill.repository.PoliticianRepository;
import pl.coderslab.doestheyfulfill.service.PoliticalService;

@Slf4j
@Controller
@RequestMapping("/hello")
@RequiredArgsConstructor
public class Hello {
    private final PoliticalService politicalService;

    @GetMapping("")
    @ResponseBody
    public String hello(){
        politicalService.add(new Politician());
        return "Hello";
    }
}
