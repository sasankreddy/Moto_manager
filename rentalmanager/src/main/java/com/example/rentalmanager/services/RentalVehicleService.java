package com.example.rentalmanager.services;

import com.example.rentalmanager.model.RentalVehicle;
import com.example.rentalmanager.repositories.RentalVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

@Service
public class RentalVehicleService {

    @Autowired
    private RentalVehicleRepository rentalVehicleRepository;

    private final String USER_SERVICE_URL = "http://localhost:8080/api/users/";

    public boolean isUserRegistered(String username) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Void> response = restTemplate.getForEntity(USER_SERVICE_URL + username, Void.class);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    public RentalVehicle postVehicle(RentalVehicle vehicle, String username) throws Exception {
        if (!isUserRegistered(username)) {
            throw new Exception("User is not registered. Please register to use rental services.");
        }

        vehicle.setRegistrationNumber(generateUniqueRegistrationNumber()); // Ensure unique registration number
        return rentalVehicleRepository.save(vehicle);
    }

    public RentalVehicle updateVehicle(String registrationNumber, RentalVehicle updatedVehicle, String username) throws Exception {
        if (!isUserRegistered(username)) {
            throw new Exception("User is not registered. Please register to use rental services.");
        }

        RentalVehicle existingVehicle = rentalVehicleRepository.findByRegistrationNumber(registrationNumber);
        if (existingVehicle == null) {
            throw new Exception("Vehicle not found with registration number: " + registrationNumber);
        }

        existingVehicle.setVehicleType(updatedVehicle.getVehicleType());
        existingVehicle.setFuelType(updatedVehicle.getFuelType());
        existingVehicle.setBrand(updatedVehicle.getBrand());
        existingVehicle.setStartDate(updatedVehicle.getStartDate());
        existingVehicle.setEndDate(updatedVehicle.getEndDate());
        existingVehicle.setTown(updatedVehicle.getTown());
        existingVehicle.setPrice(updatedVehicle.getPrice());

        return rentalVehicleRepository.save(existingVehicle);
    }

    public void deleteVehicle(String registrationNumber, String username) throws Exception {
        if (!isUserRegistered(username)) {
            throw new Exception("User is not registered. Please register to use rental services.");
        }

        RentalVehicle vehicle = rentalVehicleRepository.findByRegistrationNumber(registrationNumber);
        if (vehicle == null) {
            throw new Exception("Vehicle not found with registration number: " + registrationNumber);
        }

        rentalVehicleRepository.delete(vehicle);
    }

    public List<RentalVehicle> getAvailableVehicles(String vehicleType, String town, Date startDate, Date endDate, Double startPrice, Double endPrice) {
        return rentalVehicleRepository.findByVehicleTypeAndTownAndPriceBetweenAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                vehicleType, town, startPrice, endPrice, endDate, startDate);
    }

    private String generateUniqueRegistrationNumber() {
        // Logic to generate a unique registration number
        return "REG" + System.currentTimeMillis(); // Example implementation
    }
}
