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
    	int inclusiveEnd = exclusiveEnd - 1;
		int div3 = inclusiveEnd/3;
		int div5 = inclusiveEnd/5;
		int div15 = inclusiveEnd/15;
		//Sums of series of 3 and 5 minus intersection at 15
		double sum3 = div3*(div3+1)*3*.5;
		double sum5 = div5*(div5+1)*5*.5;
		double sum15 = div15*(div15+1)*15*.5;
		double val =  sum3+sum5-sum15;
		return (int) val;
    }

}


