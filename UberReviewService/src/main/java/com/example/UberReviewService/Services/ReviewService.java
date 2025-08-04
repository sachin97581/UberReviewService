package com.example.UberReviewService.Services;

import com.example.UberReviewService.Models.Driver;
import com.example.UberReviewService.Models.Review;
import com.example.UberReviewService.Repositories.DriverRepository;
import com.example.UberReviewService.Repositories.ReviewRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewService implements CommandLineRunner {
    ReviewRepositories reviewRepositories ;
    DriverRepository driverRepository;

    public ReviewService(ReviewRepositories reviewRepositories , DriverRepository driverRepository){
        this.driverRepository = driverRepository;
        this.reviewRepositories = reviewRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******************");
        Review review = Review.builder()
                .content("Great ride!")
                .rating(5)
                .build();
        reviewRepositories.save(review);
    }

//    List<Driver> drivers = driverRepository.findAll();
//    Optional<Driver> driver = driverRepository.findAllByNameAndId();


}
