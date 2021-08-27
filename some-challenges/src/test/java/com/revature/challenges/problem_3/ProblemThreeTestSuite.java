package java.com.revature.challenges.problem_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemThreeTestSuite {

    ProblemThree sut;

    @BeforeEach
    public void setup() {
        sut = new ProblemThree();
    }

    @Test
    public void returns_5_7_13_29_given_13195() {
        assertEquals(Arrays.asList(5, 7, 13, 29), sut.findPrimeFactors(13195));
    }

    @Test
    public void returns_11_9091_given_100001() {
        assertEquals(Arrays.asList(11, 9091), sut.findPrimeFactors(100001));
    }

    @Test
    public void returns_2_2_2_2_2_2_3_643_given_123456() {
        assertEquals(Arrays.asList(2, 2, 2, 2, 2, 2, 3, 643), sut.findPrimeFactors(123456));
    }


}
