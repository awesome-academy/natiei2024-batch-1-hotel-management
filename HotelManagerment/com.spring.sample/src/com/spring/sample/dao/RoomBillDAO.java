package com.spring.sample.dao;

import com.spring.sample.entity.RoomBill;
import java.util.List;

public interface RoomBillDAO {
    List<RoomBill> getAllRoomBill() throws Exception;
    void updatePriceRoom_RoomBill(RoomBill rbUpdate) throws Exception;
    void autoUpdatePriceRoom_RoomBill() throws Exception;
    String getRoomId(String roomName) throws Exception;
    List<RoomBill> getPaidRoomBill() throws Exception;
    List<RoomBill> getUnpaidRoomBill() throws Exception;
    void insertRoomBill(RoomBill roomBill) throws Exception;
    void deleteRoomBill(RoomBill roomBill) throws Exception;
    void updateRoomBill(RoomBill roomBill, String oldRoomId) throws Exception;
}
