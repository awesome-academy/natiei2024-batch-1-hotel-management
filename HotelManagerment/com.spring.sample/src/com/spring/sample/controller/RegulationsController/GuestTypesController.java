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
@RequestMapping(value = "/regulations/guest-types")
public class GuestTypesController {
    @Autowired
    private RegulationsPageService regulationsPageService;

    @PostMapping(value = "/{id}")
    public String update(@PathVariable Integer id, @RequestParam String guestTypeName,
            @RequestParam Float surchargeRate) {
        regulationsPageService.updateGuestType(id, guestTypeName, surchargeRate);
        return "redirect:/regulations";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable Integer id) {
        regulationsPageService.deleteGuestType(id);
        return "redirect:/regulations";
    }

    @PostMapping
    public String add(@RequestParam String typeName, @RequestParam Float surchargeRate) {
        regulationsPageService.createGuestType(typeName, surchargeRate);
        return "redirect:/regulations";
    }
}
