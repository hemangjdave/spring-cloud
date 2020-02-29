package com.techrevolution.junit;

public class MyMath {

    public int sum(int... array) {
        int sum = 0;

        for (int i : array) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        MyMath myMath = new MyMath();
        System.out.println(myMath.sum(1, 2, 3));
    }

}
