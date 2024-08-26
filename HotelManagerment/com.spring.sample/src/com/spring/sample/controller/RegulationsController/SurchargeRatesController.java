package com.spring.sample.controller.RegulationsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.service.RegulationsPageService;

@Controller
@RequestMapping(value = "/regulations/surcharge-rates")
public class SurchargeRatesController {

    @Autowired
    private RegulationsPageService regulationsPageService;

    @PostMapping(value = "/{id}")
    public String update(@PathVariable int id, @RequestParam float surchargeRate) {
        regulationsPageService.updateSurchargeRate(id, surchargeRate);
        return "redirect:/regulations";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable int id) {
        regulationsPageService.deleteSurchargeRate(id);
        return "redirect:/regulations";
    }

    @PostMapping
    public String add(@RequestParam int id, @RequestParam float surchargeRate) {
        regulationsPageService.createSurchargeRate(id, surchargeRate);
        return "redirect:/regulations";
    }

}
