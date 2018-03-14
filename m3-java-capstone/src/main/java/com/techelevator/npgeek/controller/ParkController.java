package com.techelevator.npgeek.controller;

import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.npgeek.dao.ParkDao;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
//    @SessionAttributes({"product", "shoppingCart", "itemsInCart"})  Survey Session, temp
public class ParkController {

    @Autowired
    ParkDao parkDao;
    @Autowired
    WeatherDao weatherDao;


    @RequestMapping(path="/allParks", method= RequestMethod.GET)
    public String showAllParks(ModelMap model, Park park) {
        List<Park> parks= parkDao.getAllParks();
        model.addAttribute("allParks", parks);


        return "allParks";
    }

    @RequestMapping(path = "/parkDetails", method = RequestMethod.GET)
    public String handleParkDetails(
            @RequestParam String parkCode, ModelMap model, Weather weather) {
        model.addAttribute("park", parkDao.getParkByParkCode(parkCode));
//        List<Weather> weathers = weatherDao.getWeatherByParkCode(parkCode);
        model.addAttribute("weather", weatherDao.getWeatherByParkCode(parkCode));
        return "parkDetails";


    }

}
