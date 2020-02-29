package com.techrevolution.microservice.limitsservice.controller;

import com.techrevolution.microservice.limitsservice.configuration.Configuration;
import com.techrevolution.microservice.limitsservice.configuration.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    private final Configuration configuration;

    @Autowired
    public LimitsConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping(LimitsConfigurationControllerConstants.LIMIT_URL)
    public LimitConfiguration getLimitConfiguration(){
        return new LimitConfiguration(configuration.getMaximum() , configuration.getMinimum());
    }

}
