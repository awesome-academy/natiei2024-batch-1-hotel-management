package com.spring.sample.dao;

import java.util.List;
import com.spring.sample.model.RevenuesModel;

public interface RevenuesDAO {
//	Long getCountRecord();
    List<Integer> getMonths();
    List<Integer> getYears();
    List<RevenuesModel> getRevenueList(int month, int year);
    List<RevenuesModel> getRevenueListByMonth(int month);
    List<RevenuesModel> getRevenueListByYear(int year);
  
}
