package com.spring.sample.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.sample.entity.Revenues;
import com.spring.sample.model.RevenuesModel;

public interface RevenuesService {
    // Lấy danh sách các tháng có trong cơ sở dữ liệu
    List<Integer> getMonths() throws SQLException;

    // Lấy danh sách các năm có trong cơ sở dữ liệu
    List<Integer> getYears() throws SQLException;

    // Lấy danh sách doanh thu theo tháng và năm
    List<RevenuesModel> getRevenueList(int month, int year) throws SQLException;
    
    List<RevenuesModel> getRevenueListByMonth(int month) throws SQLException;
    List<RevenuesModel> getRevenueListByYear(int year) throws SQLException;
}
