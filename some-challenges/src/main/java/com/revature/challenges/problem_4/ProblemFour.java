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

        for(int i = (int)Math.pow(10, (factorDigitLength)); i > (int)Math.pow(10, (factorDigitLength-1)) ; i--)
            for(int j = i; i-(int)Math.pow(10, (factorDigitLength-1)) < j ; j--)
                if (isPalindromic(i * j))
                    return i * j;


        return -1;
    }

    public boolean isPalindromic(int palindrome){

        String palin = Integer.toString(palindrome);

        String reversed = "";
        for(int i = palin.length()-1; i >= 0; i-- ){
            reversed += palin.charAt(i);
        }


        return reversed.equals(palin);

    }

}
