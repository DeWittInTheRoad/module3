package com.techelevator.npgeek.controller;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@SessionAttributes({"isCelsius", "parkCode"})
@Controller
public class ParkController {

    @Autowired
    ParkDao parkDao;
    @Autowired
    WeatherDao weatherDao;
    @Autowired
    SurveyDao surveyDao;


    @RequestMapping(path = "/allParks", method = RequestMethod.GET)
    public String showAllParks(Model model) {
        model.addAttribute("allParks", parkDao.getAllParks());


        return "allParks";
    }

    @RequestMapping(path = "/parkDetails/{parkCode}", method = RequestMethod.GET)
    public String handleParkDetails(
            Model model, @PathVariable String parkCode, HttpSession session) {
        String convert = (String) session.getAttribute("convert");

        if (convert == null) {
            convert = "F";
            session.setAttribute("convert", convert);
        }

        model.addAttribute("park", parkDao.getParkByParkCode(parkCode));
        model.addAttribute("weather", weatherDao.getWeatherByParkCode(parkCode));
        return "parkDetails";

    }

    @RequestMapping(path = {"/parkDetails/{parkCode}"}, method = RequestMethod.POST)
    public String chooseTempScale(@PathVariable String parkCode, @RequestParam String convert, HttpSession session, ModelMap modelHolder) {
        session.setAttribute("convert", convert);

        return "redirect:/parkDetails/{parkCode}";
    }


    @RequestMapping(path = "/survey", method = RequestMethod.GET)
    public String newSurveyInput(ModelMap model) {
        if (!model.containsAttribute("survey")) {
            model.addAttribute("survey", new Survey());
        }

        return "survey";
    }

    @RequestMapping(path = "/survey", method = RequestMethod.POST)
    public String newReviewInputSubmission(@Valid @ModelAttribute("survey") Survey survey, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "survey";
        }
        surveyDao.save(survey);
        return "redirect:/favoriteParks";
    }

    @RequestMapping(path = "/favoriteParks", method = RequestMethod.GET)
    public String showAllReviews(ModelMap model) {
        model.addAttribute("allSurveys", surveyDao.getAllSurveys());


        return "favoriteParks";
    }

}
