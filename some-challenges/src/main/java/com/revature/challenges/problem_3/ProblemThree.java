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
        int n = candidate;

        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                prime.add(i);
                n /= i;
            }
        }
        return prime;
    }

    public static void main(String[] args){
        ProblemThree result = new ProblemThree();
        System.out.println(result.findPrimeFactors(1000001));
    }

}