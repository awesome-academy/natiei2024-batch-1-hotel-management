package com.spring.sample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.spring.sample.entity.Room;
import com.spring.sample.entity.RoomType;
import com.spring.sample.service.RoomService;
import com.spring.sample.service.RoomTypeService;

@Controller
@EnableWebMvc
public class RoomsController {
	private static final Logger logger = LoggerFactory.getLogger(RoomsController.class);

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@GetMapping(value ="/rooms")
	public String index(ModelMap model, 
			@RequestParam(value = "roomId", required = false, defaultValue = "-1") String roomIdStr,
			@RequestParam(value = "roomType", required = false, defaultValue = "-1") String roomType,
			@RequestParam(value = "roomStatus", required = false, defaultValue = "-1") Integer roomStatus) {
		List<Room> rooms = new ArrayList<>();
		List<RoomType> roomTypes = new ArrayList();
		Integer roomID = -1;
		logger.info("Requesting login form");
		try {
			roomTypes = roomTypeService.getAllTypeRooms();
			if (roomIdStr != null && !roomIdStr.isEmpty()) {
				roomID = Integer.parseInt(roomIdStr);
			} 			 
			rooms = roomService.filterRoom(roomID, roomType, roomStatus);
		} catch (Exception e) {
			model.addAttribute("errorMessage",
					"Lưu ý: Mã phòng không bao gồm chữ và ký tự đặc biệt");
		} finally {
			model.addAttribute("rooms", rooms);
			model.addAttribute("roomTypes", roomTypes);
			model.addAttribute("searchedRoomId", roomIdStr.equals("-1") ? "" : roomIdStr);
			model.addAttribute("searchedRoomType", roomType);
			model.addAttribute("searchedRoomStatus", roomStatus);
		}
		return "rooms/index";
	}

}