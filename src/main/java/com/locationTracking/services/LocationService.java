package com.locationTracking.services;

import com.locationTracking.entities.LocationEntity;

public interface LocationService {
    LocationEntity getLocation(String deviceId);
    void consume(LocationEntity locationEntity);
}
