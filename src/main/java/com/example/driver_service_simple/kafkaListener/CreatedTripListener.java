package com.example.driver_service_simple.kafkaListener;

import com.example.driver_service_simple.event.CreateTripEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreatedTripListener {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(topics = "trip_create_wait_driver", groupId = "driver-service-group")
    public void listenTripCreated(String message) {
        try {
            CreateTripEvent event = objectMapper.readValue(message, CreateTripEvent.class);
            // Process the event (e.g., log, update DB, etc.)
            System.out.println("Received trip event: " + event);
            // add websocket notification logic here if needed
            simpMessagingTemplate.convertAndSend("/topic/tripCreated", event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
