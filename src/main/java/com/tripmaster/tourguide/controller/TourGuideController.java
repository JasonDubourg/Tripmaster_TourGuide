package com.tripmaster.tourguide.controller;

import com.tripmaster.tourguide.service.FeignLocationService;
import com.tripmaster.tourguide.service.FeignRewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TourGuideController {

    @Autowired
    private FeignLocationService feignLocationService;

    @Autowired
    private FeignRewardsService feignRewardsService;

    // ##### Call the location #####
    @RequestMapping("/location")
    public String getLocationService() {
        return feignLocationService.helloLocation();
    }

    // ##### Call the rewards  #####
    @GetMapping("/rewards")
    public String getRewardsService() {
        return feignRewardsService.helloRewards();
    }

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

}