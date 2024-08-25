package com.spring.sample.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sample.entity.Users;

@Controller
@RequestMapping("/regulations")
public class RegulationsController {
	private static final Logger logger = LoggerFactory.getLogger(RegulationsController.class);

	@ModelAttribute
    public void checkLoggedIn(HttpSession session, Model model) {
        Users usersSession = (Users) session.getAttribute("users");

        // Kiểm tra xem người dùng đã đăng nhập chưa hoặc không có quyền truy cập
        if (usersSession == null || usersSession.getPermission().getRegulationManagement() == 0) {
            model.addAttribute("errorMessage", "Vui lòng đăng nhập hoặc bạn không có quyền truy cập vào chức năng này.");
            // Chuyển hướng về trang đăng nhập
            throw new RuntimeException("Bạn chưa đăng nhập hoặc không có quyền truy cập vào trang này"); // Ném ngoại lệ để chuyển hướng
        }
    }
	
	@GetMapping
	public String index(Locale locale, Model model,HttpSession session) {
		Users usersSession = (Users) session.getAttribute("users");
		if (usersSession == null) {
			return "redirect:/login-page"; // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
		}
		logger.info("Requesting regulation page");
		return "regulation/index";
	}
}
