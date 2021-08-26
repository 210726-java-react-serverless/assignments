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

        List<Integer> answer = new ArrayList<>();

        if (candidate == 1)
            return answer;

        int i = 2;

        // This one kept me up at night, almost did way too much work lol
        while (i < candidate)
        {
            if(candidate % i == 0){
                answer.add(i);
                candidate /= i;
            }else
                i++;

        }
        answer.add(i);


        return answer;
    }

}
