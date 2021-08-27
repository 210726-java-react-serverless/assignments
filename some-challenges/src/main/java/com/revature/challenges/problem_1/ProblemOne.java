package com.revature.challenges.problem_1;

import java.util.stream.IntStream;

/*

    Problem Description:

        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
        The sum of these multiples is 23. Write an algorithm to find the sum of all the multiples of
        3 or 5 below a given number "n".

    Constraints:

        0 < n <= Integer.MAX_VALUE

 */
public class ProblemOne {


    public int sumOfMultiples_3or5(int exclusiveEnd) {
        int sumOfMultiples = 0;

        for (int i=0; i<exclusiveEnd; i++) {
            if (i%3 == 0) {
                sumOfMultiples += i;
            } else if (i%5 == 0) {
                sumOfMultiples += i;
            }
        }
        return sumOfMultiples;
    }

}
