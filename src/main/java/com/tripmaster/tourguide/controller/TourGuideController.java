package com.tripmaster.tourguide.controller;

import com.tripmaster.tourguide.service.FeignLocationService;
import com.tripmaster.tourguide.service.FeignRewardsService;
import com.tripmaster.tourguide.user.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TourGuideController {

    @Autowired
    private FeignLocationService feignLocationService;

    @Autowired
    private FeignRewardsService feignRewardsService;

    @GetMapping("/getRewards")
    public String getUserRewards(@RequestParam("userName") String userName) {
        return feignRewardsService.getUserRewards(userName);
    }

    @GetMapping("/getLocation")
    public String getLocation(@RequestParam("userName") String userName) {
        return feignLocationService.getLocation(userName);
    }

    @GetMapping("/getAllCurrentLocations")
    public String getAllCurrentLocations() {
        return feignLocationService.getAllCurrentLocations();
    }

    @GetMapping("/getTripDeals")
    public String getTripDeals(@RequestParam("userName") String userName) {
        return feignRewardsService.getTripDeals(userName);
    }

    @GetMapping("/getNearbyAttractions")
    public String getNearbyAttractions(@RequestParam("userName") String userName) {
        return feignLocationService.getNearbyAttractions(userName);
    }

    @PutMapping("/setUserPreferences")
    public String setUserPreferences(@RequestParam String userName, @RequestBody UserPreferences userPreferences) {
        return feignLocationService.setUserPreferences(userName, userPreferences);
    }

}