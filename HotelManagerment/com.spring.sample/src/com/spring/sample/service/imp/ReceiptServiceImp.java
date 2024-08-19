package com.spring.sample.service.imp;

import com.spring.sample.entity.Receipt;
import com.spring.sample.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImp extends BaseServiceImpl implements ReceiptService {

    private ReceiptServiceImp() {
    	
    }
    
    @Override
    public List<Receipt> getAllReceipts() {
        return receiptDAO.getAllReceipts();
    }

    @Override
    public Receipt getReceiptById(Long id) {
        return receiptDAO.getReceiptById(id);
    }

    @Override
    public void saveReceipt(Receipt receipt) {
        receiptDAO.saveReceipt(receipt);
    }

    @Override
    public void deleteReceipt(Long id) {
        receiptDAO.deleteReceipt(id);
    }
}
