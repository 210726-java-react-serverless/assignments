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

    //fibonacci n + (n-1)
    public long sumEvenFibNumbers(int exclusiveEnd) {
        long sum =0;
        long first=0;
        long second=0;


        for (int i = 2; i < exclusiveEnd; i++);
           long temp = first;
           first = second;
           second = temp + first;
            //check if number is even
          if  ( temp % 2 == 0){
                sum += temp ;

        }
          return sum;

        }
           // fibonnaci sequence for reference: sumEvenFibNumbers(n - 1) + sumEvenFibNumbers(n - 2);


        return -1L;
    }
}
