package com.example.rentalmanager.repositories;

import com.example.rentalmanager.model.RentalVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RentalVehicleRepository extends JpaRepository<RentalVehicle, Long> {

    RentalVehicle findByRegistrationNumber(String registrationNumber);

    List<RentalVehicle> findByVehicleTypeAndTownAndPriceBetweenAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            String vehicleType, String town, Double startPrice, Double endPrice, Date endDate, Date startDate);
}
