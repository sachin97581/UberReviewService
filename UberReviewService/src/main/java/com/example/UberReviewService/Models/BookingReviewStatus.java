package com.example.UberReviewService.Models;


import jakarta.persistence.Enumerated;


public enum BookingReviewStatus {

    SCHEDULE,

    CANCELLED,

    CAB_ARRIVED,

    ASSIGNING_DRIVER,

    IN_RIDE,

    COMPLETE
}
