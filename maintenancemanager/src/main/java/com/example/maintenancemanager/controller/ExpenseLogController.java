package com.example.maintenancemanager.controller;

import com.example.maintenancemanager.model.ExpenseLog;
import com.example.maintenancemanager.service.ExpenseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseLogController {

    @Autowired
    private ExpenseLogService expenseLogService;

    @PostMapping("/add")
    public ExpenseLog addOrUpdateExpenseLog(
            @RequestParam String registrationNumber,
            @RequestParam Double maintenanceCharges,
            @RequestParam Double fuelCharges,
            @RequestParam Double kilometersDriven,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date monthYear) {
        try {
            return expenseLogService.addOrUpdateExpenseLog(registrationNumber, maintenanceCharges, fuelCharges, kilometersDriven, monthYear);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/month")
    public List<ExpenseLog> getExpenseLogsForMonth(
            @RequestParam int year,
            @RequestParam int month) {
        return expenseLogService.getExpenseLogsForMonth(year, month);
    }
}
