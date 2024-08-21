package com.spring.sample.dao.imp;

import com.spring.sample.entity.RoomBill;
import com.google.protobuf.Timestamp;
import com.spring.sample.dao.RoomBillDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;


public class RoomBillDAOImp extends GenericDAOImp<RoomBill, Integer> implements RoomBillDAO {
	
	public RoomBillDAOImp() {
		super(RoomBill.class);
	}

	@Override
	public List<RoomBill> getAllRoomBill() {
		String hql = "SELECT new app.bean.RoomBill(r.RentalReceiptID, ro.RoomID, ro.RoomName, r.CheckInDate, r.CheckOutDate, r.DailyRate, r.PaymentStatus) "
				+ "FROM RECEIPTS r JOIN ROOMS ro ON r.RoomID = ro.RoomID ORDER BY r.PaymentStatus";
		Query<?> query = getSession().createQuery(hql);

		List<?> results = query.list();
		List<RoomBill> roomBills = new ArrayList<>();

		for (Object result : results) {
			Object[] row = (Object[]) result;
			String roomBillId = (String) row[0];
			String roomId = (String) row[1];
			String roomName = (String) row[2];
			String roomDateRent = ((Timestamp) row[3]).toString().substring(0, 16);
			String roomDateReturn = ((Timestamp) row[4]).toString().substring(0, 16);
			float roomPriceDay = (float) row[5];
			int roomPaymentStatus = (int) row[6];

			RoomBill roomInfoIndex = new RoomBill(roomBillId, roomName, roomDateRent, roomPaymentStatus);
			roomInfoIndex.setRoomId(roomId);
			roomInfoIndex.setRoomDateReturn(roomDateReturn);
			roomInfoIndex.setRoomPriceDay(roomPriceDay);

			roomBills.add(roomInfoIndex);
		}

		return roomBills;
	}

	@Override
	public void updatePriceRoom_RoomBill(RoomBill rbUpdate) {
		// Logic để cập nhật giá phòng
		// Chuyển đổi toàn bộ logic cập nhật giá phòng sang sử dụng Hibernate
	}

	@Override
	public void autoUpdatePriceRoom_RoomBill() {
		List<RoomBill> unpaidRoomBills = getUnpaidRoomBill();
		for (RoomBill roomBill : unpaidRoomBills) {
			updatePriceRoom_RoomBill(roomBill);
		}
	}

	@Override
	public String getRoomId(String roomName) {
		String hql = "SELECT r.RoomID FROM ROOMS r WHERE r.RoomName = :roomName";
		Query<String> query = getSession().createQuery(hql, String.class);
		query.setParameter("roomName", roomName);
		return query.uniqueResult();
	}

	@Override
	public List<RoomBill> getPaidRoomBill() {
		String hql = "SELECT new app.bean.RoomBill(r.RentalReceiptID, ro.RoomID, ro.RoomName, r.CheckInDate, r.CheckOutDate, r.DailyRate, r.PaymentStatus) "
				+ "FROM RECEIPTS r JOIN ROOMS ro ON r.RoomID = ro.RoomID WHERE r.PaymentStatus = 1";
		Query<RoomBill> query = getSession().createQuery(hql, RoomBill.class);
		return query.list();
	}

	@Override
	public List<RoomBill> getUnpaidRoomBill() {
		String hql = "SELECT new app.bean.RoomBill(r.RentalReceiptID, ro.RoomID, ro.RoomName, r.CheckInDate, r.CheckOutDate, r.DailyRate, r.PaymentStatus) "
				+ "FROM RECEIPTS r JOIN ROOMS ro ON r.RoomID = ro.RoomID WHERE r.PaymentStatus = 0";
		Query<RoomBill> query = getSession().createQuery(hql, RoomBill.class);
		return query.list();
	}

	@Override
	public void insertRoomBill(RoomBill roomBill) {
		String hqlSelectId = "SELECT r.RentalReceiptID FROM RECEIPTS r ORDER BY length(r.RentalReceiptID), r.RentalReceiptID";
		List<String> roomBillIds = getSession().createQuery(hqlSelectId, String.class).list();
		String nextRoomBillId = generateNextRoomBillId(roomBillIds);

		roomBill.setRoomBillId(nextRoomBillId);
		roomBill.setRoomPaymentStatus(0);

		getSession().save(roomBill);

		String hqlUpdateRoomState = "UPDATE ROOMS r SET r.Status = 1 WHERE r.RoomID = :roomId";
		Query<?> query = getSession().createQuery(hqlUpdateRoomState);
		query.setParameter("roomId", roomBill.getRoomId());
		query.executeUpdate();
	}

	@Override
	public void deleteRoomBill(RoomBill roomBill) {
		String hqlDeleteCustomer = "DELETE FROM RENTAL_RECEIPT_DETAILS WHERE RentalReceiptID = :rentalReceiptId";
		String hqlDeleteRoomBillUnPaid = "DELETE FROM RECEIPTS WHERE RentalReceiptID = :rentalReceiptId";
		String hqlUpdateRoomStatus = "UPDATE ROOMS SET Status = 0 WHERE RoomID = :roomId";

		Query<?> queryDeleteCustomer = getSession().createQuery(hqlDeleteCustomer);
		queryDeleteCustomer.setParameter("rentalReceiptId", roomBill.getRoomBillId());
		queryDeleteCustomer.executeUpdate();

		Query<?> queryDeleteRoomBill = getSession().createQuery(hqlDeleteRoomBillUnPaid);
		queryDeleteRoomBill.setParameter("rentalReceiptId", roomBill.getRoomBillId());
		queryDeleteRoomBill.executeUpdate();

		Query<?> queryUpdateRoomStatus = getSession().createQuery(hqlUpdateRoomStatus);
		queryUpdateRoomStatus.setParameter("roomId", roomBill.getRoomId());
		queryUpdateRoomStatus.executeUpdate();
	}

	@Override
	public void updateRoomBill(RoomBill roomBill, String oldRoomId) {
		String hqlUpdateRoomBill = "UPDATE RECEIPTS SET RoomID = :roomId, CheckInDate = :checkInDate, CheckOutDate = :checkOutDate WHERE RentalReceiptID = :rentalReceiptId";
		String hqlUpdateOldRoomState = "UPDATE ROOMS SET Status = 0 WHERE RoomID = :oldRoomId";
		String hqlUpdateNewRoomState = "UPDATE ROOMS SET Status = 1 WHERE RoomID = :newRoomId";

		Query<?> queryUpdateRoomBill = getSession().createQuery(hqlUpdateRoomBill);
		queryUpdateRoomBill.setParameter("roomId", roomBill.getRoomId());
		queryUpdateRoomBill.setParameter("checkInDate", roomBill.getRoomDateRent());
		queryUpdateRoomBill.setParameter("checkOutDate", roomBill.getRoomDateReturn());
		queryUpdateRoomBill.setParameter("rentalReceiptId", roomBill.getRoomBillId());
		queryUpdateRoomBill.executeUpdate();

		Query<?> queryUpdateOldRoomState = getSession().createQuery(hqlUpdateOldRoomState);
		queryUpdateOldRoomState.setParameter("oldRoomId", oldRoomId);
		queryUpdateOldRoomState.executeUpdate();

		Query<?> queryUpdateNewRoomState = getSession().createQuery(hqlUpdateNewRoomState);
		queryUpdateNewRoomState.setParameter("newRoomId", roomBill.getRoomId());
		queryUpdateNewRoomState.executeUpdate();
	}

	private String generateNextRoomBillId(List<String> roomBillIds) {
		if (roomBillIds.isEmpty()) {
			return "PTP1";
		} else {
			String lastRoomBillId = roomBillIds.get(roomBillIds.size() - 1);
			String prefix = lastRoomBillId.substring(0, 3);
			int suffix = Integer.parseInt(lastRoomBillId.substring(3)) + 1;
			return prefix + suffix;
		}
	}
}
