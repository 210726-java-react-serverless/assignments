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

    //Cant take credit for the idea of this algo. Found it online

    public List<Integer> findPrimeFactors(int candidate) {
        List<Integer> primeFactors = new ArrayList<>();

        while(candidate%2==0){
            candidate = candidate/2;
            primeFactors.add(2);
        }

        for(int i = 3; i < Math.sqrt(candidate); i = i + 2){
            while(candidate % i == 0){
                candidate = candidate/i;
                primeFactors.add(i);
            }
        }

        //take care of trailing remainder
        if(candidate>2)
            primeFactors.add(candidate);

        return primeFactors;
    }

}
