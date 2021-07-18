package com.tripmaster.tourguide;

import com.tripmaster.tourguide.util.LocalizationUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Locale;

@SpringBootApplication
@EnableFeignClients("com.tripmaster.tourguide.service")
public class TourguideApplication {

	public static void main(String[] args) {
		LocalizationUtil localizationUtil = new LocalizationUtil();
		Locale.setDefault(localizationUtil.getUS_LOCALE());
		SpringApplication.run(TourguideApplication.class, args);
	}

}
