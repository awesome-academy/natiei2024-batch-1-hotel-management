package com.spring.sample.dao;

import com.spring.sample.entity.RentalReceiptDetail;
import java.util.List;

public interface RentalReceiptDetailDAO {
    List<RentalReceiptDetail> getAllRentalReceiptDetails();
    RentalReceiptDetail getRentalReceiptDetailById(String customerID);
    void saveRentalReceiptDetail(RentalReceiptDetail rentalReceiptDetail);
    void deleteRentalReceiptDetail(String customerID);
}
