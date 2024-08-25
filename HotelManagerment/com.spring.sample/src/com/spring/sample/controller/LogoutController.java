package com.spring.sample.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);

    @GetMapping
    public String logout(HttpSession session) {
        // Xóa tất cả dữ liệu trong session
        session.invalidate();
        return "redirect:/login-page";
    }
}