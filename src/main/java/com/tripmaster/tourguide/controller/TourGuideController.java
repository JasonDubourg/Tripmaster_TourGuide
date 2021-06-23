package com.tripmaster.tourguide.controller;

import com.tripmaster.tourguide.service.FeignLocationService;
import com.tripmaster.tourguide.service.FeignRewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/rewards")
    public String getRewardsService() {
        return feignRewardsService.helloRewards();
    }


}