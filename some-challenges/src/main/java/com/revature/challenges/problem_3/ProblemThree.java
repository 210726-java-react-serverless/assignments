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

    public List<Integer> findPrimeFactors(int candidate) {

        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= candidate/2; i++) {
            if(candidate%i == 0) {
                int j = candidate/i;

                if(isNumberPrime(i)) {
                    list.add(i);
                } else {
                    list.addAll(findPrimeFactors(i));
                }

                if(isNumberPrime(j)) {
                    list.add(j);
                } else {
                    list.addAll(findPrimeFactors(j));
                }

                return list;

            }
        }

        return list;
    }

    private boolean isNumberPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= num/2; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }

}
