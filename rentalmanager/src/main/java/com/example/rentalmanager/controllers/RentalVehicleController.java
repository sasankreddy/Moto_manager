package com.example.rentalmanager.controllers;

import com.example.rentalmanager.model.RentalVehicle;
import com.example.rentalmanager.services.RentalVehicleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalVehicleController {

    @Autowired
    private RentalVehicleService rentalVehicleService;

    // Endpoint to post a new vehicle for rental
    @PostMapping("/post")
    public RentalVehicle postVehicle(@RequestBody RentalVehicle vehicle, HttpSession session) throws Exception {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            throw new Exception("User is not logged in. Please log in to post a vehicle.");
        }
        return rentalVehicleService.postVehicle(vehicle, username);
    }

    // Endpoint to update vehicle details
    @PutMapping("/update/{registrationNumber}")
    public RentalVehicle updateVehicle(@PathVariable String registrationNumber, @RequestBody RentalVehicle updatedVehicle, HttpSession session) throws Exception {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            throw new Exception("User is not logged in. Please log in to update a vehicle.");
        }
        return rentalVehicleService.updateVehicle(registrationNumber, updatedVehicle, username);
    }

    // Endpoint to delete a vehicle
    @DeleteMapping("/delete/{registrationNumber}")
    public String deleteVehicle(@PathVariable String registrationNumber, HttpSession session) throws Exception {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            throw new Exception("User is not logged in. Please log in to delete a vehicle.");
        }
        rentalVehicleService.deleteVehicle(registrationNumber, username);
        return "Vehicle deleted successfully!";
    }

    // Endpoint to fetch available rental vehicles based on filters
    @GetMapping("/available")
    public List<RentalVehicle> getAvailableVehicles(
            @RequestParam String vehicleType,
            @RequestParam String town,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            @RequestParam Double startPrice,
            @RequestParam Double endPrice) {
        return rentalVehicleService.getAvailableVehicles(vehicleType, town, startDate, endDate, startPrice, endPrice);
    }

}
