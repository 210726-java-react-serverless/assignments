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

    // if i remember correctly, there's a formula for fibonacci number involving the golden ratio that could be used here
    public int sumOfMultiples_3or5(int exclusiveEnd) {
        int result = 0;
        int i = 0;

        while (i < exclusiveEnd) {
            result += i;
            switch (i%3) {
                case 0:
                    switch (i%5) {
                        case 0:
                        case 1:
                        case 2:
                            i += 3;
                            break;
                        case 3:
                            i += 2;
                            break;
                        case 4:
                            i += 1;
                            break;
                    }
                    break;
                case 1:
                    i += 2;
                    break;
                case 2:
                    i += 1;
                    break;
            }
        }
        return result;
    }

}
