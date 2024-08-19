package com.spring.sample.service;

import com.spring.sample.entity.RentalReceiptDetail;

import java.util.List;

public interface RentalReceiptDetailService {
    List<RentalReceiptDetail> getAllRentalReceiptDetails();
    RentalReceiptDetail getRentalReceiptDetailById(String rentalReceiptID);
    void saveRentalReceiptDetail(RentalReceiptDetail rentalReceiptDetail);
    void deleteRentalReceiptDetail(String rentalReceiptID);
}
