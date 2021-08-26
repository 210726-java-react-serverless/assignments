package com.revature.challenges.problem_4;

/*
    Problem Description:

        A palindromic number reads the same both ways. The largest palindrome made from the product of
        two 2-digit numbers is 9009 = 91 × 99.

        Find the largest palindrome made from the product of two numbers whose digit length is "n".

    Constraints:

        1 <= n <= 4

 */

// This could probably work with Long but god would it take a *while* to execute.
public class ProblemFour {

    public int largestPalindromicNumber(int factorDigitLength) {

        double i = 1;
        double o = 1;
        int a = 1;
        int checkNum = 0;
        int topNum = 0;

        while(Math.log10(i)<factorDigitLength) {
            while(Math.log10(o)<factorDigitLength){
                checkNum = (int) (o * i);
                if (isPalindrome(checkNum))
                    if (checkNum>topNum)
                        topNum = checkNum;
                o++;
            }
            i++;
            o=i;
        }

        return topNum;
    }


    public boolean isPalindrome(int num) {

        int flipNumber = num;
        int reversed = 0;
        int remaining;

        // This took a while because I wanted to do it mathematically rather than with a string lol
        while(flipNumber != 0){
            // Get the first digit
            remaining = flipNumber % 10;
            // Bump first digit up (if it exists) and then slot in the new digit
            reversed = reversed * 10 + remaining;
            // Drop the first number and repeat if there are numbers left.
            flipNumber /= 10;
        }

        return num == reversed;
    }

}
