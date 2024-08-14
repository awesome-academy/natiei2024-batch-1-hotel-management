package com.spring.sample.controller;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.sample.service.RoomService;

@Controller
@EnableWebMvc
public class RoomCategoriesController {
	private static final Logger logger = LoggerFactory.getLogger(RoomCategoriesController.class);
	
	@Autowired
	RoomService roomService;
	
	@GetMapping(value = "/room-categories")
	public String index(Locale locale, Model model) {
		logger.info("Requesting roomcategory form");
		return "RoomCategory/index";
	}
	
	@GetMapping(value = "/count-room")
	public String testdata(Locale locale, Model model) {
		Long count = roomService.loadCCountRecord();
		model.addAttribute("count", count);
		logger.info("Requesting login form");
		return "RoomCategory/test";
	}
}