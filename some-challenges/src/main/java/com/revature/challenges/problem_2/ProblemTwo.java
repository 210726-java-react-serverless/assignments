package com.revature.challenges.problem_2;

import java.util.stream.IntStream;

/*
    Problem Description:

        Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting
        with 1 and 2, the first 10 terms will be:

            1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

        By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the
        sum of the even-valued terms up to index "n" of the sequence.

        Constraints:

            1 < n <= 91

 */
public class ProblemTwo {

    public long sumEvenFibNumbers(int exclusiveEnd) {

        if(exclusiveEnd < 2) return 0;

        long[] fibNumbers = new long[exclusiveEnd];
        fibNumbers[0] = 1;
        fibNumbers[1] = 2;
        long sum = 2;

        for (int i = 2; i < fibNumbers.length; i++){
            fibNumbers[i] = fibNumbers[i-1] + fibNumbers[i-2];
            if(fibNumbers[i] % 2 == 0) sum += fibNumbers[i];
        }

        return sum;
    }
}
