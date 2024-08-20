package com.spring.sample.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Room> listRooms = roomService.getAllRooms();
		model.addAttribute("listRooms", listRooms);
		List<RoomType> listTypeOfRooms = roomTypeService.getAllTypeRooms();
		model.addAttribute("listTypeRooms", listTypeOfRooms);
		return "RoomCategory/index";
	}

	// XÓA PHÒNG
	@PostMapping("/delete")
	public String deleteRoom(@RequestParam("roomID") Integer roomID, Model model) {

		try {

			roomService.deleteRoomById(roomID);
			logger.info("Phòng với ID: {} đã được xóa thành công.", roomID);

		} catch (Exception e) {

			model.addAttribute("errorMessage", "Có lỗi xảy ra khi xóa phòng với ID: " + roomID + ". Vui lòng thử lại.");
		}

		return "redirect:/room-categories";
	}

	// Cập nhật thông tin phòng
	@PostMapping("/update")
	public String updateRoom(@RequestParam("roomID") Integer roomID, @RequestParam("nameRoom") String nameRoom,
			@RequestParam("typeRoom") Integer typeRoomId, @RequestParam("noteRoom") String note) {
		// Tìm RoomType bằng ID
		RoomType roomType = roomTypeService.findById(typeRoomId);
		// Cập nhật phòng
		roomService.UpdateRoom(roomID, nameRoom, note, roomType);
		return "redirect:/room-categories";
	}

	// Xử lý thêm phòng mới
	@PostMapping("/add")
	public String addRoom(@RequestParam("nameRoom") String nameRoom, @RequestParam("typeRoom") Integer typeRoomID,
			@RequestParam("noteRoom") String noteRoom, Model model) {
		
	
				System.out.println("nameRoom: " + nameRoom);
				System.out.println("typeRoomId: " + typeRoomID);
				System.out.println("noteRoom: " + noteRoom);

		try {
			RoomType roomType = roomTypeService.findById(typeRoomID);
			if (roomType == null) {
				throw new RuntimeException("RoomType không tồn tại với ID: " + typeRoomID);
			}

			Room newRoom = new Room();
			newRoom.setRoomName(nameRoom);
			newRoom.setRoomType(roomType);
			newRoom.setNote(noteRoom);

			roomService.save(newRoom);
			logger.info("Phòng mới đã được thêm thành công.");
		} catch (Exception e) {
			logger.error("Có lỗi xảy ra khi thêm phòng mới.", e);
			model.addAttribute("errorMessage", "Có lỗi xảy ra khi thêm phòng mới. Vui lòng thử lại.");
		}

		return "redirect:/room-categories";
	}

}
