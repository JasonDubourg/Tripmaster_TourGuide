package com.tripmaster.tourguide.service;

import com.tripmaster.tourguide.user.UserPreferences;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tourguide-location-service", url = "localhost:8081")
public interface FeignLocationService {

    @GetMapping(value = "/location")
    String helloLocation();

    @GetMapping(value = "/getLocation")
    String getLocation(@RequestParam("userName") String userName);

    @GetMapping(value = "/getAllCurrentLocations")
    String getAllCurrentLocations();

    @GetMapping(value = "/getNearbyAttractions")
    String getNearbyAttractions(@RequestParam("userName") String userName);

    @PutMapping(value = "/setUserPreferences")
    String setUserPreferences(@RequestParam("userName") String userName, @RequestBody UserPreferences userPreferences);

}
