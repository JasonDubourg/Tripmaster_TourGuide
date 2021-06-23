package com.tripmaster.tourguide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tourguide-rewards-service", url = "localhost:8082")
public interface FeignRewardsService {

    @GetMapping(value = "/rewards")
    String helloRewards();
}
