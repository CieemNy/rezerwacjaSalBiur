package com.projektZETO.signup.uzytkownik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/uzytkownik")
public class UzytkownikController {

    @Autowired private UzytkownikService uzytkownikService;
    @Autowired private UzytkownikRepository uzytkownikRepository;

    @GetMapping(path ="api/v1/uzytkownik")

    public List<Uzytkownik> uzytkownikList(){
        return uzytkownikRepository.findAll();
    }

    @GetMapping("/logowanie")
    public String pokazLogowanie(Uzytkownik uzytkownik)
    {
        return "uzytkownik-save";
    }

    @GetMapping("/dodaj")
    public String dodajUzytkownik(@Valid Uzytkownik uzytkownik, BindingResult result, Model model)
    {
        if (result.hasErrors()){
            return "dodaj";
        }
        uzytkownikRepository.save(uzytkownik);
        return "redirect:/uzytkownik";
    }

    @GetMapping("uzytkownik/save")
    public String saveUzytkownik(Uzytkownik uzytkownik)
    {
        uzytkownikService.save(uzytkownik);

        return "redirect:/uzytkownik";
    }

    @GetMapping("/uzytkownik/edit/{id}")
    public String pokazUpdate(@PathVariable("id")long id, Model model)
    {
        Uzytkownik uzytkownik = uzytkownikRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException
                        ("Niepoprawne id uzytkownika!"));

        model.addAttribute("uzytkownik",uzytkownik);
        return "update-uzytkownik";
    }

    @GetMapping("/update/{id}")
    public String updateUzytkownik (@PathVariable("id")long id,
                                    @Valid Uzytkownik uzytkownik,
                                    BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            uzytkownik.setIdUzytkownik(id);
            return "update-uzytkownik";
        }
        uzytkownikRepository.save(uzytkownik);
        return "redirect:/uzytkownik";
    }

    @GetMapping("/usun/{id}")
    public String usunUzytkownik(@PathVariable("id") long id, Model model)
    {
        Uzytkownik uzytkownik = uzytkownikRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nieprawidlowe id uzytkownika"));
        uzytkownikRepository.delete(uzytkownik);
        return "redirect:/uzytkownik";
    }
}
