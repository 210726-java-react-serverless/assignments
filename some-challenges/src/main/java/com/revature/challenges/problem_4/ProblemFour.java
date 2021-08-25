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
        String potentialPalindrome = "";
        int biggestPalindrome = 0;
        int startNum = 9;
        if (factorDigitLength == 2) { startNum = 99; }
        if (factorDigitLength == 3) { startNum = 999; }
        if (factorDigitLength == 4) { startNum = 9999; }

        for (int i = startNum; i > 0; i--) {
            for (int j = startNum; j > 0; j--) {
                potentialPalindrome = Integer.toString(i*j);
                if (i*j > biggestPalindrome && potentialPalindrome.equals(reverse(potentialPalindrome))) {
                    biggestPalindrome = i*j;
                }
            }
        }
        return biggestPalindrome;
    }

    public String reverse(String forward) {
        String result = "";
        for (int i = 0; i < forward.length(); i++) {
            result += forward.substring((forward.length()-1)-i,forward.length()-i);
        }
        return result;
    }

}
