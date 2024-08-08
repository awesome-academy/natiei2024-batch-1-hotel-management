package com.spring.sample.controller;

import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.sample.model.CustomUserDetails;


@Controller
@EnableWebMvc
public class RoomCategoryController {
	private static final Logger logger = LoggerFactory.getLogger(RoomCategoryController.class);
	@GetMapping(value = "/room-category")
	public String RoomCategory(Locale locale, Model model) {
		logger.info("Requesting roomcategory form");
		return "sessions/RoomCategory/RoomCategory";
	}
}



