package pl.coderslab.doestheyfulfill.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.doestheyfulfill.domain.Politician;
import pl.coderslab.doestheyfulfill.service.PoliticianService;

@Slf4j
@Controller
@RequestMapping("/hello")
@RequiredArgsConstructor
public class Hello {
    private final PoliticianService politicianService;

    @GetMapping("")
    @ResponseBody
    public String hello(){
        politicianService.add(new Politician());
        return "Hello";
    }
}
