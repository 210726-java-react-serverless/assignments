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
        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i< candidate; i++) {
            while(candidate%i == 0) {
                primes.add(i);
                candidate = candidate/i;
            }
        }
        if(candidate >2) {
            primes.add(candidate);
        }

        return primes;
    }

}
