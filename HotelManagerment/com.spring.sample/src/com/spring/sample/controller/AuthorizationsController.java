package com.spring.sample.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.entity.Permission;
import com.spring.sample.entity.Users;
import com.spring.sample.service.PermissionService;
import com.spring.sample.service.UsersService;

@Controller
@RequestMapping("/authorizations")
public class AuthorizationsController {
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationsController.class);

	@Autowired
	private UsersService usersService;

	@Autowired
	private PermissionService permissionService;

	@ModelAttribute
	public void checkLoggedIn(HttpSession session, Model model) {
		Users usersSession = (Users) session.getAttribute("users");

		// Kiểm tra xem người dùng đã đăng nhập chưa hoặc không có quyền truy cập
		if (usersSession == null || usersSession.getPermission().getUserManagement() == 0) {
			model.addAttribute("errorMessage",
					"Vui lòng đăng nhập hoặc bạn không có quyền truy cập vào chức năng này.");
			// Chuyển hướng về trang đăng nhập
			throw new RuntimeException("Bạn chưa đăng nhập hoặc không có quyền truy cập vào trang này"); // Ném ngoại lệ
																											// để chuyển
																											// hướng
		}
	}

	@GetMapping
	public String index(Locale locale, Model model, HttpSession session) {
		Users usersSession = (Users) session.getAttribute("users");
		if (usersSession == null) {
			return "redirect:/login-page"; // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
		}
		List<Users> users = usersService.getAllUsers();
		List<Permission> permissions = permissionService.getAllPermissions();
		model.addAttribute("users", users);
		model.addAttribute("permissions", permissions);
		return "Authorization/index";
	}

	// Xóa user
	@PostMapping("/delete")
	public String deleteUsers(@RequestParam("username") String username, Model model) {
		try {
			usersService.deleteByUserName(username);
			logger.info("User với username: {} đã được xóa thành công.", username);
		} catch (Exception e) {
			model.addAttribute("errorMessage",
					"Có lỗi xảy ra khi xóa user với username: " + username + ". Vui lòng thử lại.");
		}
		return "redirect:/authorizations";
	}

	@PostMapping("/add")
	public String addUser(@RequestParam("fullName") String fullName, @RequestParam("userName") String username,
			@RequestParam("password") String password, @RequestParam("roleId") int roleId, Model model) {
		try {
			// Tạo một đối tượng Users mới
			Users newUser = new Users();
			newUser.setFullName(fullName);
			newUser.setUsername(username);
			newUser.setPassword(password);
			// Thêm quyền cho người dùng
			Permission permission = permissionService.findById(roleId);
			newUser.setPermission(permission);

			// Lưu người dùng vào cơ sở dữ liệu
			usersService.save(newUser);

			logger.info("Tài khoản mới đã được tạo: {}", username);
			return "redirect:/authorizations"; // Quay lại trang phân quyền
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Có lỗi xảy ra khi thêm tài khoản. Vui lòng thử lại.");
			return "Authorization/index"; // Trả về trang phân quyền nếu có lỗi
		}
	}

	@PostMapping("/update")
	public String updateUser(@RequestParam("fullName") String fullName, @RequestParam("username") String username,
			@RequestParam("roleId") int roleId, Model model) {
		try {
			// Tìm người dùng theo username
			Users user = usersService.findByUsername(username);
			if (user != null) {
				// Cập nhật thông tin
				user.setFullName(fullName);
				// Cập nhật quyền cho người dùng
				Permission permission = permissionService.findById(roleId);
				user.setPermission(permission);

				// Lưu cập nhật vào cơ sở dữ liệu
				usersService.save(user);
				logger.info("Người dùng {} đã được cập nhật thành công.", username);
			} else {
				model.addAttribute("errorMessage", "Người dùng không tồn tại.");
			}
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Có lỗi xảy ra khi cập nhật thông tin người dùng. Vui lòng thử lại.");
			logger.error("Lỗi khi cập nhật thông tin người dùng: {}", e.getMessage());
		}
		return "redirect:/authorizations"; // Quay lại trang danh sách người dùng
	}

	@PostMapping("/updatePermissions")
	public String updatePermissions(@RequestParam("permissionID") int permissionID,
			@RequestParam("permissionName") String permissionName,
			@RequestParam(value = "roomManagement", required = false) Boolean roomManagement,
			@RequestParam(value = "rentalReceiptManagement", required = false) Boolean rentalReceiptManagement,
			@RequestParam(value = "roomLookup", required = false) Boolean roomLookup,
			@RequestParam(value = "invoiceManagement", required = false) Boolean invoiceManagement,
			@RequestParam(value = "revenueReport", required = false) Boolean revenueReport,
			@RequestParam(value = "userManagement", required = false) Boolean userManagement,
			@RequestParam(value = "regulationManagement", required = false) Boolean regulationManagement, Model model) {
		try {
			// Retrieve existing permission using the roleID
			Permission permission = permissionService.findById(permissionID);
			if (permission != null) {
				// Update permission fields
				permission.setRoomManagement(roomManagement != null ? (roomManagement ? 1 : 0) : 0);
				permission.setRentalReceiptManagement(
						rentalReceiptManagement != null ? (rentalReceiptManagement ? 1 : 0) : 0);
				permission.setRoomLookup(roomLookup != null ? (roomLookup ? 1 : 0) : 0);
				permission.setInvoiceManagement(invoiceManagement != null ? (invoiceManagement ? 1 : 0) : 0);
				permission.setRevenueReport(revenueReport != null ? (revenueReport ? 1 : 0) : 0);
				permission.setUserManagement(userManagement != null ? (userManagement ? 1 : 0) : 0);
				permission.setRegulationManagement(regulationManagement != null ? (regulationManagement ? 1 : 0) : 0);

				// Save updated permissions
				permissionService.save(permission);
				logger.info("Quyền người dùng {} đã được cập nhật thành công.", permissionName);
			} else {
				model.addAttribute("errorMessage", "Quyền không tồn tại.");
			}
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Có lỗi xảy ra khi cập nhật quyền. Vui lòng thử lại.");
			logger.error("Lỗi khi cập nhật quyền: {}", e.getMessage());
		}
		return "redirect:/authorizations"; // Redirect to the authorization page after updating
	}

}
