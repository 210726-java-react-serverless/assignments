package com.revature.challenges.problem_4;

/*
    Problem Description:

        A palindromic number reads the same both ways. The largest palindrome made from the product of
        two 2-digit numbers is 9009 = 91 × 99.

        Find the largest palindrome made from the product of two numbers whose digit length is "n".

    Constraints:

        1 <= n <= 4

 */
public class ProblemFour {

    public int largestPalindromicNumber(int factorDigitLength) {
        StringBuilder intString;

        int max=0;
        for (int i = (int) Math.pow(10, factorDigitLength-1); i <= (int) Math.pow(10, factorDigitLength); i++)
            for (int j = (int) Math.pow(10, factorDigitLength - 1); j < (int) Math.pow(10, factorDigitLength); j++) {
                intString = new StringBuilder(String.valueOf(i * j));

                if(intString.toString().equals(intString.reverse().toString()) && Integer.parseInt(intString.toString())>max)
                    max = Integer.parseInt(intString.toString());

            }
        return max;
    }

}
