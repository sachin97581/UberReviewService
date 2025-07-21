package com.example.UberReviewService.Repositories;

import com.example.UberReviewService.Models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public interface ReviewRepositories extends JpaRepository<Review , Long> {
}


//@Repository
//@Component
//public class ReviewRepositories implements CommandLineRunner {
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("*************");
//        Review review = Review.builder()
//                .content("Great ride!")
//                .rating(5)
//                .build();
//        System.out.println(review);
//
//    }
//}
