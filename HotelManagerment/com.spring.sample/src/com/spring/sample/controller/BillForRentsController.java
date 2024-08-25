package com.spring.sample.controller;

import java.util.List;
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
@RequestMapping("/bill-for-rents")
public class BillForRentsController {
	private static final Logger logger = LoggerFactory.getLogger(BillForRentsController.class);

	@ModelAttribute
	public void checkLoggedIn(HttpSession session, Model model) {
		Users usersSession = (Users) session.getAttribute("users");

		// Kiểm tra xem người dùng đã đăng nhập chưa hoặc không có quyền truy cập
		if (usersSession == null || usersSession.getPermission().getInvoiceManagement() == 0) {
			model.addAttribute("errorMessage",
					"Vui lòng đăng nhập hoặc bạn không có quyền truy cập vào chức năng này.");
			// Chuyển hướng về trang đăng nhập
			throw new RuntimeException("Bạn chưa đăng nhập hoặc không có quyền truy cập vào trang này"); // Ném ngoại lệ
																											// để chuyển
																											// hướng
		}
	}
	@GetMapping
    public String index(Locale locale, Model model) {
        logger.info("Requesting regulation page");
        return "bill-for-rents/index";
    }
}

