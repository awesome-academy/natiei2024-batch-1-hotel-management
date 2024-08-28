package com.spring.sample.dao;

import com.spring.sample.entity.RentalReceiptDetail;
import java.util.List;

public interface RentalReceiptDetailDAO {
    List<RentalReceiptDetail> getAllRentalReceiptDetails();
    RentalReceiptDetail getRentalReceiptDetailById(Integer id);  // Thay đổi kiểu dữ liệu từ String sang Integer
    void saveRentalReceiptDetail(RentalReceiptDetail rentalReceiptDetail);
    void deleteRentalReceiptDetail(Integer id);  // Thay đổi kiểu dữ liệu từ String sang Integer
}
