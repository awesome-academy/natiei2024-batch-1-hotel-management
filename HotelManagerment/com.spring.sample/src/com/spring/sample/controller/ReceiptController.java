package com.spring.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReceiptController {

    @GetMapping("/receipt") // Hoặc đường dẫn bạn muốn
    public String showReceipt() {
        return "sessions/receipt/receipt"; 
    }
}
