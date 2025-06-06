package com.locationTracking.controller;

import com.locationTracking.entities.LocationEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final KafkaTemplate<String, LocationEntity> kafkaTemplate;

    public LocationController(KafkaTemplate<String, LocationEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sendLocation(@RequestBody LocationEntity locationEntity){
        kafkaTemplate.send("location-updates",locationEntity.getDeviceId(),locationEntity);
        return "Location data sent to Kafka";
    }
}
