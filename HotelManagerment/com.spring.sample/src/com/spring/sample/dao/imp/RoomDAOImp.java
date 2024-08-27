package com.spring.sample.dao.imp;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.query.Query;

import com.spring.sample.dao.RoomDAO;
import com.spring.sample.entity.Room;
import com.spring.sample.entity.RoomType;

public class RoomDAOImp extends GenericDAOImp<Room, Integer> implements RoomDAO {

	public RoomDAOImp() {
		super(Room.class);
	}

	@Override
	public List<Room> getAllRooms() {
		System.out.println("DA CHAY TOI DAY");
		String hql = "SELECT r FROM Room r LEFT JOIN FETCH r.roomType t";
		Query<Room> query = getSession().createQuery(hql, Room.class);
		return query.getResultList();
	}

	@Override
	public void deleteRoomById(Integer roomID) {
		// Tải thực thể Room bằng ID
		Room room = getHibernateTemplate().get(Room.class, roomID);

		// Kiểm tra xem thực thể có tồn tại không
		if (room == null) {
			throw new RuntimeException("Room not found for ID: " + roomID);
		}

		// Khóa thực thể (có thể dùng LockMode nếu cần)
		getSession().buildLockRequest(LockOptions.NONE).lock(room);

		// Xóa thực thể
		getHibernateTemplate().delete(room);
	}

	@Override
	public void updateRoom(Integer roomID, String nameRoom, String note, RoomType roomType) {
		// Tìm entity bằng ID
		Room room = getHibernateTemplate().get(Room.class, roomID);
		if (room == null) {
			throw new RuntimeException("Room not found");
		}
		// Cập nhật các thuộc tính
		room.setRoomName(nameRoom);
		room.setNote(note);
		room.setRoomType(roomType);
		// Lưu lại entity đã cập nhật
		getHibernateTemplate().update(room);
	}

	@Override
	public void save(Room newRoom) {
		getHibernateTemplate().saveOrUpdate(newRoom);
	}
	
	@Override
	public List<Room> filterRoom(Integer roomID, String roomType, Integer roomStatus){
		// Tạo HQL string dynamic
		String hql = "SELECT r FROM Room r LEFT JOIN FETCH r.roomType t WHERE 1=1";
		if(roomID != null && roomID > -1) hql += " AND r.id = :roomID";
		if(roomType != null && !roomType.equals("-1")) hql += " AND t.name = :roomType";
		if(roomStatus != null && roomStatus > -1) hql += " AND r.status = :roomStatus";
		// Thêm parameter dynamic
		Query query = getSession().createQuery(hql);
		if(roomID != null && roomID > -1) query.setParameter("roomID", roomID);
		if(roomType != null && !roomType.equals("-1")) query.setParameter("roomType", roomType);
		if(roomStatus != null && roomStatus > -1) query.setParameter("roomStatus", roomStatus);
		List<Room> rooms = query.list();
		return rooms;
	}
}
