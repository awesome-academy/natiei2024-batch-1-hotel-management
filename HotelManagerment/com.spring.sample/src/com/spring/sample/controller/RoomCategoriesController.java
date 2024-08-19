package com.spring.sample.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sample.entity.Room;
import com.spring.sample.entity.RoomType;
import com.spring.sample.service.RoomService;
import com.spring.sample.service.RoomTypeService;

@Controller
@RequestMapping("/room-categories")
public class RoomCategoriesController {

	private static final Logger logger = LoggerFactory.getLogger(RoomCategoriesController.class);
	@Autowired
	private RoomService roomService;

	@Autowired
	private RoomTypeService roomTypeService;

	@GetMapping
	public String index(Locale locale, Model model) {
		// In toan bo danh sach phong
		List<Room> listRooms = roomService.getAllRooms();
		model.addAttribute("listRooms", listRooms);
		// Hien thi danh sach cac loai phong
		List<RoomType> listTypeOfRooms = roomTypeService.getAllTypeRooms();
		model.addAttribute("listTypeRooms", listTypeOfRooms);
		return "RoomCategory/index";
	}
}