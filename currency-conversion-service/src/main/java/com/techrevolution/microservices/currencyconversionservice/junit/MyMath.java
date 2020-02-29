package com.techrevolution.microservices.currencyconversionservice.junit;

import java.util.stream.Stream;

public class MyMath {

    public int sum(Integer... args) {

        Stream<Integer> integerStream = Stream.of(args);

        return integerStream.mapToInt(integer -> integer).sum();

    }


    public static void main(String[] args) {
        MyMath myMath = new MyMath();
        System.out.println(myMath.sum(1, 2, 3, 4));
    }
}
