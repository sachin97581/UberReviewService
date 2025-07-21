package com.example.UberReviewService.Services;

import com.example.UberReviewService.Models.Review;
import com.example.UberReviewService.Repositories.ReviewRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class ReviewService implements CommandLineRunner {
    ReviewRepositories reviewRepositories ;

    public ReviewService(ReviewRepositories reviewRepositories){
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
}
