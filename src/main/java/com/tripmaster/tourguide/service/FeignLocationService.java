package com.tripmaster.tourguide.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tourguide-location-service", url = "localhost:8081")
public interface FeignLocationService {

    @GetMapping(value = "/location")
    String helloLocation();
}
