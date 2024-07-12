package pl.coderslab.doestheyfulfill.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.doestheyfulfill.domain.PoliticalParty;
import pl.coderslab.doestheyfulfill.domain.Politician;
import pl.coderslab.doestheyfulfill.service.PoliticalPartyService;
import pl.coderslab.doestheyfulfill.service.PoliticianService;

import java.util.List;
import java.util.Optional;
@Slf4j
@Controller
@RequestMapping("/politician")
@RequiredArgsConstructor
public class PoliticianController {
    private final PoliticianService politicianService;
    private final PoliticalPartyService politicalPartyService;

    @GetMapping("/all")
    public String politicalAll(Model model) {
        model.addAttribute("allPoliticians", politicianService.getPoliticians());
        return "politiciansList";
    }

    @GetMapping("/add")
    public String addPolitician(Model model) {
        model.addAttribute("politicianAdd", new Politician());
        return "politicianForm";
    }

    @PostMapping("/add")

    public String addParty(@Valid Politician politician, BindingResult result) {
        if (result.hasErrors()) {
            return "politicianForm";
        }
        politicianService.add(politician);
        return "redirect:/politician/add";
    }

    @GetMapping("/edit/{id}")
    public String editParty(@PathVariable Long id, Model model) {
        Optional<Politician> politician = politicianService.get(id);
        if (politician.isPresent()) {
            Politician polit = politician.get();
            model.addAttribute("politicianToEdit", polit);
            model.addAttribute("funnyPartyNames", politicalPartyService.getPoliticiansParty());
            return "editPolitician";
        } else return "redirect:/politician/all";

    }
    @PostMapping("/edit")
    public String editParty(@ModelAttribute("politicianToEdit") @Valid Politician politician, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editPolitician";
        }
        politicianService.update(politician);
        return "redirect:/politician/all";
    }
    @GetMapping("/remove/{id}")
    public String removeParty(@PathVariable Long id){
        politicianService.delete(id);
        return "redirect:/politician/all";
    }
    @GetMapping("/{id}")
    public String getPolticianDetails(@PathVariable Long id, Model model){
        Optional<Politician> politician = politicianService.get(id);
        if (politician.isPresent()) {
            Politician politDetails = politician.get();
            model.addAttribute("politicianDetails", politDetails);
            return "politicians";
        } else return "redirect:/politician/all";

    }
    @ModelAttribute("funnyPartyNames")
    public List<PoliticalParty> politicalParties(){
      return   politicalPartyService.getPoliticiansParty();
    }

}
