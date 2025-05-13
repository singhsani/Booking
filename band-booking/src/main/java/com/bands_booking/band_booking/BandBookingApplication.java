package com.bands_booking.band_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BandBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BandBookingApplication.class, args);
	}

}
