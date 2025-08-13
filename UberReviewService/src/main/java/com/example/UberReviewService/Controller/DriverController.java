package com.example.UberReviewService.Controller;


import com.example.UberReviewService.Models.Driver;
import com.example.UberReviewService.Services.DriverServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    DriverServiceImp driverServiceImp;

    DriverController(DriverServiceImp driverServiceImp) {
        this.driverServiceImp = driverServiceImp;
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        Driver dr = driverServiceImp.CreateDriver(driver);
        return new ResponseEntity<>(dr, HttpStatus.CREATED);
    }

    // get all driver


    // get driver by id

    
    // delete driver and all review associated with driver

}