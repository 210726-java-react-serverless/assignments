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

        List<Integer> look = new ArrayList<>();

        while (candidate % 2 == 0) {
            look.add(2);
            candidate = candidate/ 2;
        }


        for (int i = 3; i <= Math.sqrt(candidate); i += 2) {

            while (candidate % i == 0) {
                look.add(i);
                candidate =candidate/ i;
            }
        }


        if (candidate > 2)
            look.add(candidate);

        return look;
    }


}
