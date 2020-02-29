package com.techrevolution.microservices.currencyconversionservice.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    MyMath myMath = new MyMath();

    @Test
    void sum() {

        assertSame(6, myMath.sum(1, 2, 3));
        assertSame(1, myMath.sum(1));
        assertSame(-1, myMath.sum(-1));

    }
}