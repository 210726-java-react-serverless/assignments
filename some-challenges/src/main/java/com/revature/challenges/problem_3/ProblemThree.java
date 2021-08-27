package com.revature.challenges.problem_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    Problem Description:

        The prime factors of 13195 are 5, 7, 13 and 29. Write an algorithm that calculates the prime factors
        for a given number "n".

    Constraints:

        0 < n <= 1000001

 */
public class ProblemThree {
    List<Integer> primeMap = new ArrayList<>(50);
    public List<Integer> findPrimeFactors(int candidate) {
        int tempnum = candidate;
        int j = 0;
        while (tempnum%2 == 0)
        {
            primeMap.add(j,2);
            j++;
            tempnum = tempnum/2;
        }

        for (int i = 3; i <Math.sqrt(candidate); i+=2)
        {
            while (tempnum%i == 0)
            {
                primeMap.add(j,i);
                j++;
                tempnum=tempnum/i;
            }
        }
        if (tempnum>2)
        {
            primeMap.add(j,tempnum);
        }
        return primeMap;

    }

}
