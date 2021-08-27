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
        int r=2;
        int q = candidate;
        List<Integer> numbersList = new ArrayList<>();

        while(r<=candidate){
            if(q%r==0) {
                q = (int) (q / r);
                numbersList.add(r);
                continue;
            } else {
                r++;
            }
        }
        return numbersList;

    }

}
