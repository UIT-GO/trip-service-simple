package com.example.driver_service_simple.controller;

import com.example.driver_service_simple.request.AcceptTripRequest;
import com.example.driver_service_simple.service.DriverService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @PostMapping()
    public ResponseEntity<String> acceptTrip(@RequestBody AcceptTripRequest acceptTripRequest) throws JsonProcessingException {
        // Placeholder implementation
        return ResponseEntity.ok(driverService.acceptTrip(acceptTripRequest.getDriverId(), acceptTripRequest.getTripId()));
    }
}
