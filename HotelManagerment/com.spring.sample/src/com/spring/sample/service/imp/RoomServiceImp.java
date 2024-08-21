package com.spring.sample.service.imp;

import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.sample.entity.Room;
import com.spring.sample.entity.RoomType;
import com.spring.sample.service.RoomService;

@Service
public class RoomServiceImp extends BaseServiceImpl implements RoomService {

	private RoomServiceImp() {
	}

	@Override
	public List<Room> getAllRooms() {
		return roomDAO.getAllRooms();
	}

	@Override
	public void deleteRoomById(Integer roomID) {
		roomDAO.deleteRoomById(roomID); // Gọi phương thức từ DAO để xóa phòng theo roomId
	}

	@Override
	public void UpdateRoom(Integer roomID, String nameRoom, String note, RoomType roomType) {
		roomDAO.UpdateRoom(roomID, nameRoom, note, roomType);
	}

	@Override
	public void save(Room newRoom) {
		roomDAO.save(newRoom);
	}
}
