package com.example.handlingformsubmission;

import com.example.handlingformsubmission.model.Airline;
import com.example.handlingformsubmission.service.ServiceApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @Autowired
    ServiceApp serviceApp;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }


    @GetMapping("/airlines")
    public String airlinesForm(Model model) {
        model.addAttribute("airlines", serviceApp.getAirlines().iterator());
        return "airlines";
    }

    @GetMapping("/seats")
    public String airlinesSeats(Model model) {
        model.addAttribute("airline", new Airline());
        return "airlineForm";
    }

    @PostMapping("/seat")
    public String seatSubmit(@ModelAttribute Airline airline) {
        airline.setEconomySeat(serviceApp.getEconomySeatsFromAirlines(airline.getAirlineNameShort(),airline.getAirlineNameLong()));
        return "airlineFormResult";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        serviceApp.getAirlines();
        return "result";
    }
    /*
    @PostMapping("/firstClass")
    public String firstSeatSubmit(@ModelAttribute Airline airline) {
    	airline.getFirstClassSeat(serviceApp.getFirstClassFromAirlines(airline.getAirlineNameShort(), airline.getAirlineNameShort()));
    	return"/firstClass";
    */ 
 }
    


