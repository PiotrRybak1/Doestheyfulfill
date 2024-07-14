package pl.coderslab.doestheyfulfill.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.doestheyfulfill.domain.Politician;
import pl.coderslab.doestheyfulfill.domain.Promise;
import pl.coderslab.doestheyfulfill.domain.PromiseStatus;
import pl.coderslab.doestheyfulfill.service.PoliticianService;
import pl.coderslab.doestheyfulfill.service.PromiseService;
import pl.coderslab.doestheyfulfill.service.PromisesStatusService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Controller
@RequestMapping("/promise")
@RequiredArgsConstructor
public class PromiseController {
    private final PromiseService promiseService;
    private final PromisesStatusService promisesStatusService;
    private final PoliticianService politicianService;

    @GetMapping("/all")
    public String promisesAll(Model model) {
        model.addAttribute("promisesAll", promiseService.getPromises());
        return "promisesList";
    }
    @GetMapping("/{id}")
    public String getDetails(@PathVariable Long id, Model model){
        Optional<Promise> optionalPromise =promiseService.get(id);
        if(optionalPromise.isPresent()){
            model.addAttribute("promiseDetails", optionalPromise.get());
            return "detailsPromise";
        }
        else return "redirect:/promise/all";

    }

    @GetMapping("/add")
    public String addPromise(Model model) {
        model.addAttribute("addPromise", new Promise());
        return "promiseForm";
    }

    @PostMapping("/add")
    public String addPromise(@Valid Promise promise, BindingResult result) {
        if (result.hasErrors()) {
            return "promiseForm";
        }
        promiseService.add(promise);
        return "redirect:/promise/add";
    }
    @GetMapping("/addPolitician/{id}")
    public  String createPromiseWithPolitician(@PathVariable Long id, Model model){
        Optional<Politician> politicianOptional = politicianService.get(id);
        if(politicianOptional.isPresent()){
            Politician politician = politicianOptional.get();
            Promise promise = new Promise();
            promise.setPolitician(politician);
            model.addAttribute("promise2",promise);
            return "promiseForm2";
        }
        else return "redirect:/politician/all";
    }
    @PostMapping("/addPolitician")
    public String createPromiseWithPolitician(@Valid @ModelAttribute("promise2") Promise promise, BindingResult result){
        if (result.hasErrors()) {
            return "promiseForm2";
        }
        promiseService.add(promise);
        return "redirect:/politician/all";
    }
    @GetMapping("/edit/{id}")
    public String editPromise(@PathVariable Long id, Model model){
      Optional<Promise> optionalPromise =promiseService.get(id);
      if(optionalPromise.isPresent()){
          model.addAttribute("promiseForEdit", optionalPromise.get());
          return "editPromise";
      }
      else return "redirect:/promise/all";
    }

    @PostMapping("/edit")
        public String editPromise(@ModelAttribute("promiseForEdit") @Valid Promise promise, BindingResult result){
            if(result.hasErrors()){
                return "editPromise";
        }
            promiseService.update(promise);
            return "redirect:/promise/all";
    }
    @GetMapping("/remove/{id}")
    public String removePromise(@PathVariable Long id){
        promiseService.delete(id);
        return "redirect:/promise/all";
    }
    @GetMapping("/politician/{id}")
    public String politicianPromises(@PathVariable Long id, Model model){
        Optional<Politician> politician = politicianService.get(id);
        if(politician.isPresent()){
            Politician politician1 = politician.get();
            Set<Promise> promiseSet = promiseService.politicianPromises(politician1);
            model.addAttribute("promisesPolitician", promiseSet);
            return "politicianPromises";
        }
        else return "redirect:/politician/all";
    }


    @ModelAttribute("promiseStatusModel")
    public List<PromiseStatus> promiseStatusForPromise(){
        return  promisesStatusService.all();
    }
    @ModelAttribute("politicianModel")
    public List<Politician> politiciansForPromise(){
        return politicianService.getPoliticians();
    }
}
