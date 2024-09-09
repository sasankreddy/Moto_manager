package com.example.maintenancemanager.service;

import com.example.maintenancemanager.model.ExpenseLog;
import com.example.maintenancemanager.repositories.ExpenseLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseLogService {

    @Autowired
    private ExpenseLogRepository expenseLogRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String VEHICLE_MANAGER_URL = "http://vehiclemanager/api/vehicles/";

    public boolean isVehicleRegistered(String registrationNumber) {
        try {
            restTemplate.getForObject(VEHICLE_MANAGER_URL + registrationNumber, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ExpenseLog addOrUpdateExpenseLog(String registrationNumber, Double maintenanceCharges, Double fuelCharges, Double kilometersDriven, Date monthYear) {
        if (!isVehicleRegistered(registrationNumber)) {
            throw new RuntimeException("Vehicle is not registered.");
        }

        ExpenseLog expenseLog = expenseLogRepository.findById(registrationNumber).orElse(new ExpenseLog());
        expenseLog.setRegistrationNumber(registrationNumber);
        expenseLog.setMaintenanceCharges(maintenanceCharges);
        expenseLog.setFuelCharges(fuelCharges);
        expenseLog.setKilometersDriven(kilometersDriven);
        expenseLog.setMonthYear(monthYear);
        return expenseLogRepository.save(expenseLog);
    }

    public List<ExpenseLog> getExpenseLogsForMonth(int year, int month) {
        return expenseLogRepository.findByMonthYearYearAndMonthYearMonth(year, month);
    }
}
