package com.revature.challenges.problem_3;

import java.util.ArrayList;
import java.util.List;

/*

    Problem Description:

        The prime factors of 13195 are 5, 7, 13 and 29. Write an algorithm that calculates the prime factors
        for a given number "n".

    Constraints:

        0 < n <= 1000001

 */
public class ProblemThree {

    public static List<Integer> getPrimeNumbers(int candidate) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 2; i <= candidate; i++)
        {
            if (i == 2 || i == 3) {
                intList.add(i);
                continue;
            }
            for (int j = 2; j <= i / 2; j++)
            {
                if (i % j == 0)
                    break;
                if (j == i / 2)
                    intList.add(i);
            }
        }
        return intList;
    }

    public static List<Integer> findPrimeFactors(int candidate) {
        List<Integer> intList = new ArrayList<>();
        System.out.println(getPrimeNumbers(candidate));
        for (int prime : getPrimeNumbers(candidate)) {
            if (candidate % prime == 0)
                intList.add(prime);
        }
        return intList;
    }

    public static void main(String[] args) {
        final int EXCLUSIVE_END = 100136;
        System.out.println(EXCLUSIVE_END + " has prime factors of:\n" + findPrimeFactors(EXCLUSIVE_END));
    }

}
