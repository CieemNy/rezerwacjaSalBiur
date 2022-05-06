package com.zeto.rezerwacja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zeto.rezerwacja.domain.PomieszczenieRezerwacja;
import com.zeto.rezerwacja.service.PomieszczenieRezerwacjaService;

@RestController
@RequestMapping(value="/api")
public class RezerwacjaServiceController {

    @Autowired
    private PomieszczenieRezerwacjaService pomieszczenieRezerwacjaService;
    @RequestMapping(method=RequestMethod.GET, value="/reservations/{date}")

    public List<PomieszczenieRezerwacja> getAllReservationsForDate(@PathVariable(value="date")String dateString) {
        return this.pomieszczenieRezerwacjaService.getPomieszczenieRezerwacjeForDate(dateString);
    }
}