package com.tripmaster.tourguide;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.tripmaster.tourguide.controller.TourGuideController;
import com.tripmaster.tourguide.service.FeignLocationService;
import com.tripmaster.tourguide.service.FeignRewardsService;
import com.tripmaster.tourguide.user.AttractionDto;
import com.tripmaster.tourguide.user.UserLocationDto;
import com.tripmaster.tourguide.user.UserPreferences;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;

@WebMvcTest(TourGuideController.class)
public class TourGuideControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FeignLocationService locationFeignClient;

    @MockBean
    private FeignRewardsService rewardsFeignProxy;

    @DisplayName("Injected Components Are Rightly Setup")
    @Test
    public void injectedComponentsAreRightlySetup() {
        assertThat(mockMvc).isNotNull();
        assertThat(locationFeignClient).isNotNull();
        assertThat(rewardsFeignProxy).isNotNull();
    }


    @DisplayName("GET : /getLocation")
    @Test
    void givenGettingTheLocationOfTheUser_whenGetLocation_thenItDisplayTheCoordinateOfTheUserAsJSON() throws Exception {
        // ARRANGE
        when(locationFeignClient.getLocation(any(String.class))).thenReturn(any(String.class));

        // ACT
        MvcResult mvcResult = this.mockMvc.perform(get("/getLocation?userName=userName")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(locationFeignClient, times(1)).getLocation(any(String.class));
    }

    @DisplayName("GET : /getNearbyAttractions")
    @Test
    void givenGettingTheFiveClosestAttrationsOfTheUser_whenGetNearbyAttraction_thenItDisplayTheRequestedDataForTheUserAsJSON()
            throws Exception {
        // ARRANGE
        when(locationFeignClient.getNearbyAttractions(any(String.class))).thenReturn(String.valueOf((new ArrayList<AttractionDto>())));

        // ACT
        MvcResult mvcResult = this.mockMvc.perform(get("/getNearbyAttractions?userName=userName")).andDo(print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(locationFeignClient, times(1)).getNearbyAttractions(any(String.class));
    }

    @DisplayName("GET : /getRewards")
    @Test
    void givenGettingTheRewardsOfTheUser_whenGetRewards_thenItDisplayTheRewardsOfTheUserAsJSON() throws Exception {
        // ARRANGE
        when(rewardsFeignProxy.getUserRewards(any(String.class))).thenReturn(any(String.class));

        // ACT
        MvcResult mvcResult = this.mockMvc.perform(get("/getRewards?userName=userName")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(rewardsFeignProxy, times(1)).getUserRewards(any(String.class));
    }

    @DisplayName("GET : /getAllCurrentLocations")
    @Test
    void givenGettingAllCurrentLocations_whenGetAllCurrentLocations_thenItDisplayTheLocationOfEveryUsers()
            throws Exception {
        // ARRANGE
        when(locationFeignClient.getAllCurrentLocations()).thenReturn(String.valueOf(new ArrayList<UserLocationDto>()));

        // ACT
        MvcResult mvcResult = this.mockMvc.perform(get("/getAllCurrentLocations")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(locationFeignClient, times(1)).getAllCurrentLocations();
    }

    @DisplayName("GET : /getTripDeals")
    @Test
    void givenGettingTheTripDealsOfTheUser_whenGetTripDeals_thenItDisplayTheTripDealsOfTheUserAsJSON()
            throws Exception {
        // ARRANGE
        when(rewardsFeignProxy.getTripDeals(any(String.class))).thenReturn(any(String.class));

        // ACT
        MvcResult mvcResult = this.mockMvc.perform(get("/getTripDeals?userName=userName")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(rewardsFeignProxy, times(1)).getTripDeals(any(String.class));
    }

    @DisplayName("PUT : /setUserPreferences")
    @Test
    void givenSettingTheUserPreferences_whenSetUserPreferences_thenItCorrectlyChangeTheUserPreferencesWithTheProvidedData()
            throws Exception {
        // ARRANGE
        when(locationFeignClient.setUserPreferences(any(String.class), any(UserPreferences.class))).thenReturn("");

        // ACT
        MvcResult mvcResult = this.mockMvc.perform(put("/setUserPreferences?userName=userName")
                .contentType(MediaType.APPLICATION_JSON).content("{\"attractionProximity\":\"0\"}")).andDo(print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(locationFeignClient, times(1)).setUserPreferences(any(String.class), any(UserPreferences.class));
    }
}
