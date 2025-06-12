package com.locationTracking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class LocationEntity {

   @Id
    private String deviceId;
    private String longitude;
    private String latitude;
    private Date timestamp;

    public LocationEntity() {
    }

    public LocationEntity(String deviceId, String longitude, String latitude, Date timestamp) {
        this.deviceId = deviceId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
    }

//    public String getDeviceId() {
//        return deviceId;
//    }
//
//    public void setDeviceId(String deviceId) {
//        this.deviceId = deviceId;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
//
//    public String getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
//
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }

//    @Override
//    public String toString(){
//        return "LocationEntity{" +
//                "deviceId='" + deviceId + '\'' +
//                ", latitude=" + latitude +
//                ", longitude=" + longitude +
//                ", timestamp=" + timestamp +
//                '}';
//
//    }
}
