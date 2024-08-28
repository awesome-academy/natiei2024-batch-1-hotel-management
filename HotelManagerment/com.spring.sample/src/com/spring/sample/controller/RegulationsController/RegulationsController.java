package com.spring.sample.controller.RegulationsController;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sample.entity.GuestTypes;
import com.spring.sample.entity.RoomType;
import com.spring.sample.entity.Setting;
import com.spring.sample.entity.SurchargeRate;
import com.spring.sample.service.RegulationsPageService;

@Controller
@RequestMapping("/regulations")
public class RegulationsController {
    private static final Logger logger = LoggerFactory.getLogger(RegulationsController.class);

    @Autowired
    private RegulationsPageService regulationsPageService;

    @GetMapping
    public String index(Locale locale, Model model) {
        logger.info("Requesting regulation page");
        List<RoomType> listOfRoomTypes = regulationsPageService.getAllRoomTypes();
        List<GuestTypes> listOfGuestTypes = regulationsPageService.getAllGuestTypes();
        List<Setting> listOfSettings = regulationsPageService.getAllSettings();
        List<SurchargeRate> listOfSurchargeRates = regulationsPageService.getAllSurchargeRates();
        model.addAttribute("roomTypes", listOfRoomTypes);
        model.addAttribute("guestTypes", listOfGuestTypes);
        model.addAttribute("settings", listOfSettings);
        model.addAttribute("surchargeRates", listOfSurchargeRates);
        return "regulation/index";
    }

}
