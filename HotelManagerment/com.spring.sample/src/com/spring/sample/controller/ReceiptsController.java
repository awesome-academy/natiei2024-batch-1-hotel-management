package com.spring.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.sample.entity.Receipt;
import com.spring.sample.entity.RentalReceiptDetail;
import com.spring.sample.service.ReceiptService;
import com.spring.sample.service.RentalReceiptDetailService;

import java.util.List;

@Controller
public class ReceiptsController {

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private RentalReceiptDetailService rentalReceiptDetailService;

    @GetMapping("/receipts")
    public String listReceipts(Model model) {
        // Lấy danh sách Receipt từ service
        List<Receipt> receipts = receiptService.getAllReceipts();
        
        // Đưa dữ liệu lên model để chuyển tới view (HTML)
        model.addAttribute("receipts", receipts);
        
        // Trả về file receipt.html
        return "sessions/receipt/index";
    }
    
    @GetMapping("/receipts/{id}")
    public String viewReceiptDetails(@PathVariable Integer id, Model model) {
        RentalReceiptDetail rentalReceiptDetail = rentalReceiptDetailService.getRentalReceiptDetailById(id);
        
        // Thêm thông tin chi tiết hóa đơn vào mô hình
        model.addAttribute("id", rentalReceiptDetail.getRentalReceiptID());
        model.addAttribute("issueDate", rentalReceiptDetail.getIssueDate());
        model.addAttribute("paymentDate", rentalReceiptDetail.getPaymentDate());
        model.addAttribute("totalAmount", rentalReceiptDetail.getTotalAmount());
        model.addAttribute("invoicePaymentStatusText", rentalReceiptDetail.getInvoicePaymentStatusText());
        model.addAttribute("rentalReceiptDetails", rentalReceiptDetail);
        
        return "sessions/receipt/show";
    }


}
