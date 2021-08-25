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

        List<Integer> result = new ArrayList<>();
        boolean haveFactorization = false;
        int toFactor = candidate;
        int factor;

        while (!haveFactorization) {
            factor = smallestFactor(toFactor);
            if (factor == 1) {
                result.add(toFactor);
                haveFactorization = true;
            } else if (isPrime(factor)) {
                result.add(factor);
                toFactor /= factor;
            }
        }
        return result;
    }

    public boolean isPrime(int potentialPrime) {
        if (potentialPrime == 1) { return false; }
        if (potentialPrime == 2) { return true; }
        for (int i = 2; i < (potentialPrime/2)+1; i++) {
            if (potentialPrime%i == 0) { return false; }
        }
        return true;
    }

    public int smallestFactor(int number) {
        for (int i = 2; i < number; i++) {
            if (i > number/2) { break; }
            if (number%i == 0) { return i; }
        }
        return 1;
    }

}
