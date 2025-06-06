package com.locationTracking.services.Impl;

import com.locationTracking.entities.LocationEntity;
import com.locationTracking.repositories.LocationRepository;
import com.locationTracking.services.LocationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public LocationServiceImpl(LocationRepository locationRepository, SimpMessagingTemplate messagingTemplate) {
        this.locationRepository = locationRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public LocationEntity getLocation(String deviceId) {
        return null;
    }

    @Override
    @KafkaListener(topics = "location-updates",groupId = "location-group")
    public void consume(LocationEntity locationEntity) {
        System.out.println("Kafka message received: {}"+locationEntity);
        LocationEntity entity = new LocationEntity();
        entity.setDeviceId(locationEntity.getDeviceId());
        entity.setLatitude(locationEntity.getLatitude());
        entity.setLongitude(locationEntity.getLongitude());
        entity.setTimestamp(locationEntity.getTimestamp());
        locationRepository.save(entity);

        messagingTemplate.convertAndSend("/topic/locations",locationEntity);
    }
}
