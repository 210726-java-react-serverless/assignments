package com.revature.challenges.problem_4;

import java.util.ArrayList;
import java.util.List;

/*
    Problem Description:

        A palindromic number reads the same both ways. The largest palindrome made from the product of
        two 2-digit numbers is 9009 = 91 × 99.

        Find the largest palindrome made from the product of two numbers whose digit length is "n".

    Constraints:

        1 <= n <= 4

 */
public class ProblemFour {

    public static boolean isPalindrome(int number) {
        int reversedNum = 0;
        int originalNum = number;

        while (number > 0) {
            int remainder = number % 10;
            reversedNum *= 10;
            reversedNum += remainder;
            number /= 10;
        }

        if (reversedNum == originalNum) return true;
        return false;
    }

    public static FactorsAndSum largestPalindromicNumber(int factorDigitLength) {
        List<FactorsAndSum> intList = new ArrayList<>();
        for (int i = 1; i < Math.pow(10, factorDigitLength); i++) {
            for (int j = 1; j < Math.pow(10, factorDigitLength); j++) {
                int k = i * j;
                if (isPalindrome(k)) intList.add(new FactorsAndSum(i, j, k));
            }
        }
        int max = 0;
        FactorsAndSum maxfas = null;
        for (FactorsAndSum fas : intList ) {
            if (fas.product > max) {
                max = fas.product;
                maxfas = fas;
            }
        }
        return maxfas;
    }

    public static void main(String[] args) {
        final int FACTORDIGITLENGTH = 4;
        FactorsAndSum result = largestPalindromicNumber(FACTORDIGITLENGTH);
        if (result == null) System.out.println("No palindromes found.");
        else System.out.println("The largest palindrome found was "
                                + result.factor1 + " * "
                                + result.factor2 + " which is "
                                + result.product);
    }

}
