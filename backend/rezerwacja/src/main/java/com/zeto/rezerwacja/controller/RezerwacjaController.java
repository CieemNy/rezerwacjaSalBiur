package com.zeto.rezerwacja.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeto.rezerwacja.controller.RezerwacjaController;
import com.zeto.rezerwacja.service.PomieszczenieRezerwacjaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rezerwacje")
public class RezerwacjaController{


    @Autowired
    private PomieszczenieRezerwacjaService pomieszczenieRezerwacjaService;
    @RequestMapping(method = RequestMethod.GET)
    public String getRezerwacje(@RequestParam(value="date", required=false)String dateString, Model model) {

        model.addAttribute("pomieszczenieRezerwacje",this.pomieszczenieRezerwacjaService.getPomieszczenieRezerwacjeForDate(dateString));
        return "reservations";	// Pass the string to the Spring Boot template for displaying the view
    }
}