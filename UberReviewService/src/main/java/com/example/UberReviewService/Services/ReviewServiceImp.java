package com.example.UberReviewService.Services;


import com.example.UberReviewService.Models.Review;
import com.example.UberReviewService.Repositories.ReviewRepositories;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService{

    ReviewRepositories reviewRepositories;

    @Autowired
    ReviewServiceImp(ReviewRepositories reviewRepositories){
        this.reviewRepositories = reviewRepositories;
    }

    @Override
    public Optional<Review> findReviewById(Long id) throws EntityNotFoundException {
        Optional<Review> review;
        try {
            review = this.reviewRepositories.findById(id);
            if (review.isEmpty()){
                throw new EntityNotFoundException("Review not found" + id );
            }
        }catch (Exception e ){
//            e.printStackTrace();
            throw new FetchNotFoundException("Review not found of this id " , id);
        }
        return review;
    }

    @Override
    public List<Review> findAllReview() {
        return reviewRepositories.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        Optional<Review> review;

        review = reviewRepositories.findById(id);
        review.ifPresent(reviewRepositories::delete);
        return false;
    }

    @Override
//    @Transactional
    public Review publishReview(Review review) {
        return reviewRepositories.save(review);
    }

    @Override
    public Review updateReviewById(Long id, Review newReviewData) {
        Review review = this.reviewRepositories.findById(id).orElseThrow(EntityNotFoundException::new);
        if(newReviewData.getRating() != null){
            review.setRating(newReviewData.getRating());
        }
        if(newReviewData.getContent() != null){
            review.setContent(newReviewData.getContent());
        }
        return this.reviewRepositories.save(review);
    }
}
