package com.example.driver_service_simple.request;

import lombok.Data;

@Data
public class AcceptTripRequest {
    private String driverId;
    private String tripId;
}
