package com.example.UberReviewService.Services;


import com.example.UberReviewService.Models.Review;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReview();

    public boolean deleteReviewById(Long id);

    public Review publishReview(Review review);

    public Review updateReviewById(Long id , Review review);
}
