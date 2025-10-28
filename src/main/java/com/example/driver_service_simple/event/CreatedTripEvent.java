package com.example.driver_service_simple.event;

import lombok.Data;

@Data
public class CreatedTripEvent {
    private String driverId;
    private String tripId;
}
