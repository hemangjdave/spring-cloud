package com.techrevolution.microservice.limitsservice.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LimitConfiguration {
    private int maximum;
    private int minimum;

    public LimitConfiguration(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }
}
