package com.sms.delayreactive.service;

import reactor.core.publisher.Mono;
import java.time.Duration;

@org.springframework.stereotype.Service
public class Service {
    public Mono<String> getMessage(Integer delay) {
        return Mono.just("Hello! after "+delay+" milliseconds.")
                // waiting for delay milliseconds in reactive way.
                .delayElement(Duration.ofMillis(delay));
    }
}
