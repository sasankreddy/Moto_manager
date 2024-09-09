package com.example.maintenancemanager.repositories;

import com.example.maintenancemanager.model.ExpenseLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseLogRepository extends JpaRepository<ExpenseLog, String> {

    List<ExpenseLog> findByMonthYearYearAndMonthYearMonth(int year, int month);
}
