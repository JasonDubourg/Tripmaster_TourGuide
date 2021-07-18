package com.tripmaster.tourguide.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tourguide-rewards-service", url = "localhost:8082")
public interface FeignRewardsService {

    @GetMapping(value = "/rewards")
    String helloRewards();

    @GetMapping(value = "/getRewards")
    String getUserRewards(@RequestParam("userName") String userName);

    @GetMapping(value = "/getTripDeals")
    String getTripDeals(@RequestParam("userName") String userName);
}
