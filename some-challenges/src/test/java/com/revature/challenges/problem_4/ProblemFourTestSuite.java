package com.revature.challenges.problem_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemFourTestSuite {

    ProblemFour sut;

    @BeforeEach
    public void setup() {
        sut = new ProblemFour();
    }

    @Test
    public void returns_something_given_1() {
        assertEquals(9, sut.largestPalindromicNumber(1));
    }

    @Test
    public void returns_9009_given_2() {
        assertEquals(9009, sut.largestPalindromicNumber(2));
    }

    @Test
    public void returns_something_given_3() {
        assertEquals(906609, sut.largestPalindromicNumber(3));
    }

    @Test
    public void returns_something_given_4() {
        assertEquals(99000099, sut.largestPalindromicNumber(4));
    }


}
