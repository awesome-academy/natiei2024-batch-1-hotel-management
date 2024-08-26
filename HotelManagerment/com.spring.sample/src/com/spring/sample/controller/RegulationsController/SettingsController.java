package com.spring.sample.controller.RegulationsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.service.RegulationsPageService;

@Controller
@RequestMapping("/regulations/settings")
public class SettingsController {

    @Autowired
    private RegulationsPageService regulationsPageService;

    @PostMapping(value = "/{name}")
    public String update(@PathVariable String name, @RequestParam float paramValue) {
        regulationsPageService.updateSettingByName(name, paramValue);
        return "redirect:/regulations";
    }
}
