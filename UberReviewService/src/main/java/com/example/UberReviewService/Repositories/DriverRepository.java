package com.example.UberReviewService.Repositories;

import com.example.UberReviewService.Models.Booking;
import com.example.UberReviewService.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver , Long> {


//    Optional<Driver> findByNameAndId(String name, Long id);


}

