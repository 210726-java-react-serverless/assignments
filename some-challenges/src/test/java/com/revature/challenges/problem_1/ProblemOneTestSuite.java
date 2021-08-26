package com.revature.challenges.problem_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Problem Description:

        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
        The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.

 */
public class ProblemOneTestSuite {

    ProblemOne sut;

    @BeforeEach
    public void setup() {
        sut = new ProblemOne();
    }

    @Test
    public void returns_23_given_10() {
        assertEquals(23, sut.sumOfMultiples_3or5(10));
    }

    @Test
    public void returns_2318_given_100() {
        assertEquals(2318, sut.sumOfMultiples_3or5(100));
    }

    @Test
    public void returns_233168_given_1000() {
        assertEquals(233168, sut.sumOfMultiples_3or5(1000));
    }

    @Test
    public void returns_23331668_given_10000() {
        assertEquals(23331668, sut.sumOfMultiples_3or5(10000));
    }


}
