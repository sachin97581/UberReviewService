package com.example.UberReviewService.Controller;


import com.example.UberReviewService.Models.Review;
import com.example.UberReviewService.Repositories.ReviewRepositories;
import com.example.UberReviewService.Services.ReviewServiceImp;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/v1/reviews")
@RequestMapping("/review")
public class ReviewController {

    ReviewServiceImp reviewServiceImp;

    @Autowired
    ReviewController (ReviewServiceImp reviewServiceImp){
        this.reviewServiceImp = reviewServiceImp;
    }

    @PostMapping
    public ResponseEntity<Review> publishReview(@RequestBody Review review){
        Review review1 = reviewServiceImp.publishReview(review);
        return new ResponseEntity<>(review1 , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Review>  findReviewBuId(@PathVariable Long id){
        Optional<Review> review = reviewServiceImp.findReviewById(id);
        if (review.isEmpty()){
            throw new EntityNotFoundException("Review not found");
        }
        return  review;
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAllReview(){
        List<Review> review = this.reviewServiceImp.findAllReview();
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    // update review

    // delete review by id
}
