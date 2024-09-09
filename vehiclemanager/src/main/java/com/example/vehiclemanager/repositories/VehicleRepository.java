package com.example.vehiclemanager.repositories;

import com.example.vehiclemanager.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByUsername(String username);
    Optional<Vehicle> findByRegistrationNumber(String registrationNumber);
    Optional<Vehicle> findByIdAndUsername(Long id, String username);

    Vehicle findByRegistrationNumberAndUsername(String registrationNumber, String username);
}
