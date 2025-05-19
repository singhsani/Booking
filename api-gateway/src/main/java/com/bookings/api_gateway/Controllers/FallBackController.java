package com.bookings.api_gateway.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Hystrix is a fault tolerance library, especially useful for microservices,
 * that implements the circuit breaker design pattern.
 * It helps protect against latency and failure from external dependencies,
 * preventing cascading failures and enabling graceful degradation.
 * Hystrix monitors the performance of calls to external services and opens the
 * "circuit" (stops requests) if the failure rate exceeds a predefined threshold.
 */
@RestController
public class FallBackController {
    @RequestMapping("/bandBookingService")
    public Mono<String> bandBookingServiceFallBack(){
        return Mono.just("");
    }

    @RequestMapping("/registrationService")
    public Mono<String> registrationFallBack(){
        return Mono.just("Get Too Long response");
    }
}
