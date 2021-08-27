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
        int max = 0;
        int upperLimit = (int) Math.pow(10, factorDigitLength);
        int lowerLimit = (int) Math.pow(10, factorDigitLength - 1);

        for (int i = lowerLimit; i < upperLimit; i++) {
            for (int j = lowerLimit; j < upperLimit; j++) {
                int temp = i * j;
                if (temp == checkReverse(temp) && temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public int checkReverse(int num) {
        int reverse = 0;

        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }
        return reverse;
    }

}
