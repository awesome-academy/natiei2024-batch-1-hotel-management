package com.spring.sample.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.model.RevenuesModel;
import com.spring.sample.service.RevenuesService;
import com.spring.sample.service.RoomTypeService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/revenues")
public class RevenuesController {

    @Autowired
    private RevenuesService revenuesService;

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping
    public String index(Model model) {
        try {
            List<Integer> getMonth = revenuesService.getMonths();
            List<Integer> getYear = revenuesService.getYears();
            model.addAttribute("getMonth", getMonth);
            model.addAttribute("getYear", getYear);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "revenues/index";
    }

    @GetMapping("/search")
    public String searchRevenue(@RequestParam("month") String month,
                                @RequestParam("year") String year,
                                HttpSession session,
                                Model model) {
        // Kiểm tra nếu người dùng không chọn cả tháng và năm
        if ("-1".equals(month) && "-1".equals(year)) {
            model.addAttribute("errorMessage", "Vui lòng chọn ít nhất tháng hoặc năm để tìm kiếm.");
            
            // Thêm danh sách tháng và năm vào model để giữ dropdown được hiển thị
            try {
                List<Integer> getMonth = revenuesService.getMonths();
                List<Integer> getYear = revenuesService.getYears();
                model.addAttribute("getMonth", getMonth);
                model.addAttribute("getYear", getYear);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Trả về view mà không thực hiện truy vấn
            return "revenues/index";
        }

        try {
            List<RevenuesModel> listRevenue = null;

            // Tiến hành truy vấn theo tháng hoặc năm hoặc cả hai
            if (!"-1".equals(month) && "-1".equals(year)) {
                listRevenue = revenuesService.getRevenueListByMonth(Integer.parseInt(month));
            } else if ("-1".equals(month) && !"-1".equals(year)) {
                listRevenue = revenuesService.getRevenueListByYear(Integer.parseInt(year));
            } else {
                listRevenue = revenuesService.getRevenueList(Integer.parseInt(month), Integer.parseInt(year));
            }

            double totalPriceRevenue = 0;
            for (RevenuesModel revenue : listRevenue) {
                totalPriceRevenue += revenue.getRevenueAmount();
            }

            List<Integer> getMonth = revenuesService.getMonths();
            List<Integer> getYear = revenuesService.getYears();

            model.addAttribute("totalPriceRevenue", totalPriceRevenue);
            model.addAttribute("getAllRevenueList", listRevenue);
            session.setAttribute("getAllRevenueList", listRevenue);
            model.addAttribute("monthResponse", month);
            model.addAttribute("yearResponse", year);
            model.addAttribute("getMonth", getMonth);
            model.addAttribute("getYear", getYear);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "revenues/index";
    }


    @GetMapping("/export")
    public void exportList(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=Báo cáo doanh thu.xlsx");

        @SuppressWarnings("unchecked")
        List<RevenuesModel> listRevenue = (List<RevenuesModel>) session.getAttribute("getAllRevenueList");
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Báo cáo doanh thu");

        int rowNo = 0;
        XSSFRow row = sheet.createRow(rowNo++);
        int cellNum = 0;

        // Header
        String[] headers = {"STT", "Tháng", "Năm", "Loại phòng", "Doanh thu", "Tỉ lệ"};
        for (String header : headers) {
            XSSFCell cell = row.createCell(cellNum++);
            cell.setCellValue(header);
        }

        // Details
        int i = 1;
        for (RevenuesModel revenue : listRevenue) {
            row = sheet.createRow(rowNo++);
            cellNum = 0;

            row.createCell(cellNum++).setCellValue(i++);
            row.createCell(cellNum++).setCellValue(revenue.getMonth());
            row.createCell(cellNum++).setCellValue(revenue.getYear());
            row.createCell(cellNum++).setCellValue(revenue.getTypeRoomName());
            row.createCell(cellNum++).setCellValue(revenue.getRevenueAmount());
            row.createCell(cellNum++).setCellValue(revenue.getRate());
        }

        wb.write(response.getOutputStream());
        wb.close();
    }
}
