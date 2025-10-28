package com.example.driver_service_simple.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface DriverService {
    String acceptTrip(String driverId, String tripId) throws JsonProcessingException;
}
