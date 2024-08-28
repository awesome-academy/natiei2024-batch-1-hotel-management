package com.spring.sample.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.sample.entity.Permission;
import com.spring.sample.entity.Users;
import com.spring.sample.service.PermissionService;
import com.spring.sample.service.UsersService;

@Controller
@RequestMapping("/login-page")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UsersService usersService;

	@GetMapping
	public String add(Locale locale, Model model) {
		return "sessions/login/Login";
	}

	@PostMapping
	public String login(@RequestParam("email") String email, 
	                    @RequestParam("password") String password, 
	                    Model model,
	                    HttpSession session) {
	    // Logic kiểm tra email và mật khẩu
	    Users users = usersService.isValidUser(email, password);
	    if (users != null) {
	        logger.info("Login successful for user: {}", email);
	        // Lưu user vào session
	        session.setAttribute("users", users);
	        // Đăng nhập thành công, chuyển hướng đến trang chủ 
	        return "redirect:/room-categories";
	    } else {
	        logger.info("Login failed for user: {}", email);
	        // Đăng nhập thất bại, trả về trang đăng nhập với thông báo lỗi
	        model.addAttribute("message", "Email hoặc mật khẩu không chính xác. Vui lòng thử lại.");
	        return "sessions/login/Login";
	    }
	}

}
