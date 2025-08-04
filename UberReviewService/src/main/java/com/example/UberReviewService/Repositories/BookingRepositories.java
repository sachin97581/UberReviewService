package com.example.UberReviewService.Repositories;

import com.example.UberReviewService.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;


@Repository
public interface BookingRepositories extends JpaRepository<Booking , Long> {

}
