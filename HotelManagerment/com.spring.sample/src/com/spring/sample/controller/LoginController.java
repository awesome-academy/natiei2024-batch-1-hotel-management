package com.spring.sample.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.sample.service.MicropostService;

@Controller
@EnableWebMvc
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


	@Autowired
	MicropostService micropostService;
	@GetMapping(value = "/login")
	public String add(Locale locale, Model model) {

		Long count = micropostService.loadCCountRecord();
		System.out.println("\n\n COUNTCOUNTCOUNTCOUNTCOUNTCOUNT = " + count);
		model.addAttribute("count", count);
		logger.info("Requesting login form");
		return "sessions/login/Login";
	}
}
