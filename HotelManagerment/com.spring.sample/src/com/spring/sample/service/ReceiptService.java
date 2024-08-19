package com.spring.sample.service;

import com.spring.sample.entity.Receipt;

import java.util.List;

public interface ReceiptService {
    List<Receipt> getAllReceipts();
    Receipt getReceiptById(String rentalReceiptID);
    void saveReceipt(Receipt receipt);
    void deleteReceipt(Long id);
}
