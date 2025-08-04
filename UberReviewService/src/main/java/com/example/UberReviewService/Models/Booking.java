package com.example.UberReviewService.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Booking extends BaseModel{

    @OneToOne
    private Review review;

    @Enumerated(value = EnumType.STRING)
    private BookingReviewStatus bookingReviewStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDuration;


    @ManyToOne
    private Driver driver;
}
