package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    public class HomeController {

        @RequestMapping("/")
        public String displayHomePage() {
            return "redirect:/allParks";
        }
    }


