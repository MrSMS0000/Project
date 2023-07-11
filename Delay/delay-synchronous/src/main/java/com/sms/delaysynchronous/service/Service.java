package com.sms.delaysynchronous.service;

@org.springframework.stereotype.Service
public class Service {
    public String getMessage(Integer delay) {

        // waiting for delay milliseconds in synchronous way.
        try {
            Thread.sleep(delay);
        }
        catch (InterruptedException e) {
            System.out.println("Error in Thread.sleep()");
            throw new RuntimeException(e);
        }

        return "Hello! after "+delay+" milliseconds.";
    }
}
