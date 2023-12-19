package com.example.actuator.extensions;

import org.springframework.boot.actuate.endpoint.annotation.EndpointExtension;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)  // customizing info endpoints
public class InfoEndPoints {

    @ReadOperation
    public WebEndpointResponse<String> info(){
        return new WebEndpointResponse<>("INFO", 200);
    }
}
/**
 * You can also customize the end points.
 */
