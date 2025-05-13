package com.bookings.registration_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegistrationBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationBookingApplication.class, args);
	}

}
