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
    public void returns_44_given_10() {
        assertEquals(44, sut.sumEvenFibNumbers(10));
    }

    @Test
    public void returns_3770056902373173214_given_91() {
        assertEquals(3770056902373173214L, sut.sumEvenFibNumbers(91));
    }

}
