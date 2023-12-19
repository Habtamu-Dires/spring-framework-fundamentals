package com.example.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "my-end-point")  // this creates actuator/my-end-point
public class MyCustomEndpoints {

    @ReadOperation  // accessed using GET verb
    public String test(){
        return "Hello";
    }
}
/**
 * Creating your end point
 */