package com.spring.sample.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class RegulationsController {
    private static final Logger logger = LoggerFactory.getLogger(RegulationsController.class);

    @GetMapping(value = "/regulations")
    public String index(Locale locale, Model model) {
        logger.info("Requesting regulation page");
        return "regulation/index";
    }
}
