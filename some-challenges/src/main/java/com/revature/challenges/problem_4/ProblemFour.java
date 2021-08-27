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

        int base = 1;
        for(int i = 1; i < factorDigitLength; i++) {
            base *= 10;
        }

        int largest = 0;
        int ceil = base*10;
        int num = 0;

        for(int i = base; i < ceil; i++) {
            for(int j = base; j < ceil; j++) {
                num = i*j;
                if(isPalindrome(num) && num > largest) {
                    largest = num;
                }
            }
        }

        if(largest == 0) {
            return largestPalindromicNumber(factorDigitLength-1);
        }

        return largest;

    }

    private boolean isPalindrome(int num) {

        StringBuilder snum = new StringBuilder((num + ""));

        StringBuilder muns = new StringBuilder(snum);
        muns.reverse();

        return (snum.toString()).equals((muns.toString()));

    }

}
