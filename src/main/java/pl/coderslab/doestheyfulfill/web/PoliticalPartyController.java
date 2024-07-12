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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Controller
@RequestMapping("/politicalParty")
@RequiredArgsConstructor
public class PoliticalPartyController {
    private final PoliticalPartyService politicalPartyService;
    private final PoliticianService politicianService;


    @GetMapping("/all")
    public String politicalPartyAll(Model model) {
        model.addAttribute("allParties", politicalPartyService.getPoliticiansParty());
        return "parties";
    }

    @GetMapping("/add")
    public String addParty(Model model) {
        model.addAttribute("partyAdd", new PoliticalParty());
        return "politicalPartyForm";
    }

    @PostMapping("/add")
    public String addParty(@Valid PoliticalParty party, BindingResult result) {
        if (result.hasErrors()) {
            return "politicalPartyForm";
        }
        politicalPartyService.add(party);
        return "redirect:/politicalParty/add";
    }

    @GetMapping("/edit/{id}")
    public String editParty(@PathVariable Long id, Model model) {
        Optional<PoliticalParty> party = politicalPartyService.get(id);
        if (party.isPresent()) {
            PoliticalParty politicalParty = party.get();
            model.addAttribute("partyToEdit", politicalParty);
            return "politicalPartyEdit";
        } else return "redirect:/politicalParty/all";

    }

    @PostMapping("/edit")
    public String editParty(@ModelAttribute("partyToEdit") @Valid PoliticalParty politicalParty, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editPart";
        }
        politicalPartyService.update(politicalParty);
        return "redirect:/politicalParty/all";
    }

    @GetMapping("/remove/{id}")
    public String removeParty(@PathVariable Long id) {
        politicalPartyService.delete(id);
        return "redirect:/politicalParty/all";
    }
    @GetMapping("/politicianBelong/{id}")
    public String politicians(@PathVariable Long id, Model model){
        Set<Politician> politBelong = politicianService.belongPolitician(id);
        model.addAttribute("politBelog", politBelong);
        return "belongPoliticians";
    }

    @ModelAttribute("funnyPartyNames")
    public List<PoliticalParty> funnyPartyNames() {
        return politicalPartyService.getPoliticiansParty();
                /*Arrays.asList(
                "Partia Wiecznego Luzu",
                "Partia Śpiochów Narodowych",
                "Partia Kawoszy Ekstremalnych",
                "Zjednoczona Partia Drzemki",
                "Partia Niekończących się Wakacji",
                "Partia Kiełbasy i Grilla",
                "Partia Przewracania Na Drugi Bok",
                "Partia Kawalerii Leżakowej",
                "Partia Narodowego Oglądania Seriali",
                "Partia Bezcelowych Marszów",
                "Partia Kanapowych Rewolucjonistów",
                "Partia Pączków i Pączków",
                "Partia Pancake'ów i Syropu",
                "Partia Bezstresowego Życia",
                "Partia Narodowego Chrapania",
                "Partia Żartownisiów",
                "Partia Nicnierobienia",
                "Partia Leniuchów Profesjonalnych",
                "Partia Fajerwerków i Radości",
                "Partia Grillowania i Odpoczynku",
                "Partia Popołudniowych Drzemek",
                "Partia Ciast i Kremów",
                "Partia Koców i Ciepłych Skarpet",
                "Partia Uśmiechniętych Ludzi",
                "Partia Żółwi i Powolności",
                "Partia Festynów i Pikników",
                "Partia Narodowego Leniucha",
                "Partia Żarłoków i Łasuchów",
                "Partia Spania do Południa",
                "Partia Narodowego Obijania Się",
                "Partia Pikników i Barbeku",
                "Partia Siedzenia i Gapienia Się",
                "Partia Leniwych Kotów",
                "Partia Chichotów i Uśmiechów",
                "Partia Narodowego Rozweselenia",
                "Partia Wesołych Przytulasów",
                "Partia Leżaków i Hamaków",
                "Partia Narodowego Dobrego Humoru",
                "Partia Złotych Ryb i Marzeń",
                "Partia Wędkowania i Odpoczynku",
                "Partia Narodowego Grillowania",
                "Partia Śmieszków i Figlarzy",
                "Partia Narodowego Fajrantowania",
                "Partia Masełka i Ciepłych Bułeczek",
                "Partia Słodkiego Niewolnictwa",
                "Partia Narodowego Siestowania",
                "Partia Zabawy i Uciech",
                "Partia Miłośników Kociego Spokoju",
                "Partia Czekolady i Radości",
                "Partia Spokoju i Wygody");*/
    }


}

