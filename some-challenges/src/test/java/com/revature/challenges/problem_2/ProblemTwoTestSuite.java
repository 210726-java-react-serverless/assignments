package com.revature.challenges.problem_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTwoTestSuite {

    ProblemTwo sut;

    @BeforeEach
    public void setup() {
        sut = new ProblemTwo();
    }

    @Test
    public void returns_2_given_2() {
        assertEquals(2, sut.sumEvenFibNumbers(2));
    }

    @Test
    public void returns_10_given_7() {
        assertEquals(10, sut.sumEvenFibNumbers(7));
    }

    @Test
    public void returns_44_given_10() {
        assertEquals(44, sut.sumEvenFibNumbers(10));
    }

    @Test
    public void returns_26658145586_given_50() {
        assertEquals(26658145586L, sut.sumEvenFibNumbers(50));
    }

    @Test
    public void returns_3770056902373173214_given_91() {
        assertEquals(3770056902373173214L, sut.sumEvenFibNumbers(91));
    }

}
