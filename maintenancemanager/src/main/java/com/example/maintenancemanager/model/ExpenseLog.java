package com.example.maintenancemanager.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ExpenseLog {

    @Id
    private String registrationNumber;

    @Column(nullable = false)
    private Double maintenanceCharges;

    @Column(nullable = false)
    private Double fuelCharges;

    @Column(nullable = false)
    private Double kilometersDriven;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date monthYear;

    // Getters and Setters

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Double getMaintenanceCharges() {
        return maintenanceCharges;
    }

    public void setMaintenanceCharges(Double maintenanceCharges) {
        this.maintenanceCharges = maintenanceCharges;
    }

    public Double getFuelCharges() {
        return fuelCharges;
    }

    public void setFuelCharges(Double fuelCharges) {
        this.fuelCharges = fuelCharges;
    }

    public Double getKilometersDriven() {
        return kilometersDriven;
    }

    public void setKilometersDriven(Double kilometersDriven) {
        this.kilometersDriven = kilometersDriven;
    }

    public Date getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(Date monthYear) {
        this.monthYear = monthYear;
    }

    @Override
    public String toString() {
        return "ExpenseLog{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", maintenanceCharges=" + maintenanceCharges +
                ", fuelCharges=" + fuelCharges +
                ", kilometersDriven=" + kilometersDriven +
                ", monthYear=" + monthYear +
                '}';
    }
}
