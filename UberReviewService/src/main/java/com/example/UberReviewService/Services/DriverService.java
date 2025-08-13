package com.example.UberReviewService.Services;

import com.example.UberReviewService.Models.Driver;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DriverService {

   public Optional<Driver> findDriverById(Long id);

    public Driver CreateDriver(Driver driver);

    public Driver updateDriver(Long id , Driver driver);

    public boolean deleteDriverById(Long id);
}
