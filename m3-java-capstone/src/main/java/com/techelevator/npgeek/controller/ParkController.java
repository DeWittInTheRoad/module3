package com.techelevator.npgeek.controller;

import com.techelevator.npgeek.model.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.npgeek.dao.ParkDao;

import java.util.List;


@Controller
//    @SessionAttributes({"product", "shoppingCart", "itemsInCart"})  Survey Session, temp
public class ParkController {

    @Autowired
    ParkDao parkDao;


    @RequestMapping(path="/common/homePage", method= RequestMethod.GET)
    public String showAllParks(ModelMap model, Park park) {
        List<Park> parks= parkDao.getAllParks();
        model.addAttribute("allParks", parks);


        return "/common/homePage";
    }

}
