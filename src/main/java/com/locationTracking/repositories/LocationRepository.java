package com.locationTracking.repositories;

import com.locationTracking.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity,String> {
}
