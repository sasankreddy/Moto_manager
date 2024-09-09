package com.example.vehiclemanager.services;

import com.example.vehiclemanager.exceptions.UserNotFoundException;
import com.example.vehiclemanager.model.User;
import com.example.vehiclemanager.model.Vehicle;
import com.example.vehiclemanager.repositories.UserRepository;
import com.example.vehiclemanager.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    public Vehicle registerVehicle(Vehicle vehicle, String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found with username: " + username);
        }

        // Check if the vehicle registration number is unique
        if (vehicleRepository.findByRegistrationNumber(vehicle.getRegistrationNumber()).isPresent()) {
            throw new IllegalArgumentException("Vehicle with registration number " + vehicle.getRegistrationNumber() + " already exists");
        }

        vehicle.setUsername(username);
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle, String username) throws UserNotFoundException {
        Vehicle existingVehicle = vehicleRepository.findByIdAndUsername(id, username).orElse(null);
        if (existingVehicle == null) {
            throw new UserNotFoundException("Vehicle not found or does not belong to the user");
        }

        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setBrand(updatedVehicle.getBrand());
        // Ensure registration number remains unique when updating
        if (!existingVehicle.getRegistrationNumber().equals(updatedVehicle.getRegistrationNumber()) &&
                vehicleRepository.findByRegistrationNumber(updatedVehicle.getRegistrationNumber()).isPresent()) {
            throw new IllegalArgumentException("Vehicle with registration number " + updatedVehicle.getRegistrationNumber() + " already exists");
        }
        existingVehicle.setRegistrationNumber(updatedVehicle.getRegistrationNumber());

        return vehicleRepository.save(existingVehicle);
    }

    public List<Vehicle> getVehiclesByUsername(String username) {
        return vehicleRepository.findByUsername(username);
    }

    public void deleteVehicleByRegistrationNumber(String registrationNumber, String username) throws UserNotFoundException {
        Vehicle vehicle = vehicleRepository.findByRegistrationNumberAndUsername(registrationNumber, username);
        if (vehicle == null) {
            throw new UserNotFoundException("Vehicle not found or does not belong to the user");
        }
        vehicleRepository.delete(vehicle);
    }
}
