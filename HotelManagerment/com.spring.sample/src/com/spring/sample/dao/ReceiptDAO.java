package com.spring.sample.dao;

import com.spring.sample.entity.Receipt;

import java.util.List;

public interface ReceiptDAO {
    List<Receipt> getAllReceipts();
    Receipt getReceiptById(Integer id);  // Thay đổi kiểu dữ liệu từ Long sang int
    void saveReceipt(Receipt receipt);
    void deleteReceipt(Integer id);  // Thay đổi kiểu dữ liệu từ Long sang int
}
