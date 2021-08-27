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
        int a = 0;
        int largest = 0;
        while(String.valueOf(a).length() < factorDigitLength) {
            for (int i = 1; i < 91; i++) {
                for (int j = 1; j < 99; j++) {
                    a = j*i;
                    largest = a;

                    int x=0;
                    int y=String.valueOf(a).length()-1;
                    while (i < j) {
                        if (String.valueOf(a).charAt(x) != String.valueOf(a).charAt(y))

                        x++;
                        y--;
                    }




                }
            }
        }


    return largest;

    }

}
