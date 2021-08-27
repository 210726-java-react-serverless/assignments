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

        int count3 = 1;
        int multiple3 = 3;
        int sum3 = 0;
        while(multiple3 < exclusiveEnd) {
            sum3 += multiple3;

            System.out.println("multiple3: " + multiple3);
            System.out.println("count3: " + count3);
            System.out.println("sum3: " + sum3);
            System.out.println();

            multiple3 = 3 * (++count3);
        }


        int count5 = 1;
        int multiple5 = 5;
        int sum5 = 0;
        while(multiple5 < exclusiveEnd) {
            if(((double) multiple5/3) == (double) (multiple5/3)) multiple5 = 0; // ignore repeat multiples of 3
            sum5 += multiple5;

            System.out.println("multiple5: " + multiple5);
            System.out.println("count5: " + count5);
            System.out.println("sum 5: " + sum5);
            System.out.println();

            multiple5 = 5 * (++count5);
        }

        System.out.println("Total: " + (sum3+sum5));

        return sum3 + sum5;
    }

}
