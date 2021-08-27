package main.java.com.revature.challenges.problem_3;

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

    public ProblemThree(){

    }
    static boolean isPrime(int n)
    {
        if (n <= 1){
            return false;
        }

        for (int i = 2; i < n; i++)
            if (n % i == 0){
                return false;
            }
        return true;
    }


    public List<Integer> findPrimeFactors(int candidate) {
        List factors = new ArrayList();

        for(int i = 0; i < candidate; i++){
           if(isPrime(i) == true){
               if(candidate % i == 0){
                   factors.add(i);
               }
           }
        }


        return factors;
    }

}
