package com.example.UberReviewService.Services;


import com.example.UberReviewService.Models.Driver;
import com.example.UberReviewService.Repositories.DriverRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServiceImp implements DriverService{

    DriverRepository driverRepository;

    DriverServiceImp(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @Override
    public Optional<Driver> findDriverById(Long id) throws EntityNotFoundException {
        Optional<Driver> driver;
        try{
            driver = driverRepository.findById(id);
            if (driver.isEmpty()){
               throw new EntityNotFoundException("Driver not found with id" + id);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new FetchNotFoundException("driver not found" , id);

        }
        return driver;
    }

    @Override
    public Driver CreateDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Long id, Driver driver) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));

        if (driver.getPhoneNumber() != null) {
            existingDriver.setPhoneNumber(driver.getPhoneNumber());
        }
        if (driver.getName() != null) {
            existingDriver.setName(driver.getName());
        }

        return driverRepository.save(existingDriver);
    }


    @Override
    public boolean deleteDriverById(Long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        driver.ifPresent(driverRepository::delete);
        return false;
    }
}
