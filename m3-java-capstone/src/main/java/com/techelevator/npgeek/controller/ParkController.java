package com.techelevator.npgeek.controller;

import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.npgeek.dao.ParkDao;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@Controller
//    @SessionAttributes({"product", "shoppingCart", "itemsInCart"})  Survey Session, temp
public class ParkController {

    @Autowired
    ParkDao parkDao;
    @Autowired
    WeatherDao weatherDao;
//    @Autowired
//    ForumDao forumDao;


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
        model.addAttribute("weather", weatherDao.getWeatherByParkCode(parkCode));
        return "parkDetails";


    }

    @RequestMapping(path="/survey", method=RequestMethod.GET)
    public String newSurveyInput(ModelMap model) {
        if(!model.containsAttribute("survey")){
            model.addAttribute("survey", new Survey());
        }

        return "survey";
    }

    @RequestMapping(path="/survey", method=RequestMethod.POST)
    public String newReviewInputSubmission(@Valid @ModelAttribute("survey")Survey survey, BindingResult result, ModelMap model)  {
        if(result.hasErrors()) {
            return "survey";
        }
//        newForumPost.setDatePosted(LocalDateTime.now());
//        forumDao.save(newForumPost);
        return "redirect:/favoriteParks";
    }

}
