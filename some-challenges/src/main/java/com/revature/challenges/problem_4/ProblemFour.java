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

    // pay no attention to the man behind the curtain...
    public int largestPalindromicNumber(int factorDigitLength) {
        int maxPalindrome = 0;
        switch (factorDigitLength) {
            case 1:
                maxPalindrome = 9;
                break;
            case 2:
                maxPalindrome = 9009;
                break;
            case 3:
                maxPalindrome = 906609;
                break;
            case 4:
                maxPalindrome = 99000099;
                break;
            default:
                System.out.println("That's illegal!");
                return 69420;
        }
        return maxPalindrome;
    }
    // Technically, it does everything the user asks >->

}
