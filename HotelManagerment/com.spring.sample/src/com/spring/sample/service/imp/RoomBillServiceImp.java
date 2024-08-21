package com.spring.sample.service.imp;

import com.spring.sample.service.RoomBillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sample.entity.Room;
import com.spring.sample.entity.RoomBill;
import com.spring.sample.dao.RoomBillDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class RoomBillServiceImp extends BaseServiceImpl implements RoomBillService {
	
    private final RoomBillDAO roomBillDAO;
    @Autowired
    public RoomBillServiceImp(RoomBillDAO roomBillDAO) {
        this.roomBillDAO = roomBillDAO;
    }

    @Override
    public List<RoomBill> getAllRoomBills() throws SQLException {
        return roomBillDAO.getAllRoomBill();
    }

}
