package com.spring.sample.dao;

import com.spring.sample.entity.Receipt;

import java.util.List;

public interface ReceiptDAO {
    List<Receipt> getAllReceipts();
    Receipt getReceiptById(Long id);
    void saveReceipt(Receipt receipt);
    void deleteReceipt(Long id);
}
