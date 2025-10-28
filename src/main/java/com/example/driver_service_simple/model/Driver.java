package com.example.driver_service_simple.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Driver {
    @Id
    private String id;
    private String name;
}
