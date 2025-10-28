package com.example.driver_service_simple.service;

import com.example.driver_service_simple.event.CreatedTripEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService{
    private static final String TRIP_CREATED_TOPIC = "trip_created";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public DriverServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String acceptTrip(String driverId, String tripId) throws JsonProcessingException {
        CreatedTripEvent createdTripEvent = new CreatedTripEvent();
        createdTripEvent.setDriverId(driverId);
        createdTripEvent.setTripId(tripId);

        String json = new ObjectMapper().writeValueAsString(createdTripEvent);
        System.out.println(json);
        kafkaTemplate.send(TRIP_CREATED_TOPIC, json);
        return "Driver " + driverId + " accepted trip " + tripId;
    }
}
