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

        //Needs to be optimized

        int maxIndex = (int) Math.pow(10, factorDigitLength);
        int minIndex = ((int) Math.pow(10, factorDigitLength)/10);
        int largestPalindrome = -1;
        boolean isPalindrome = true;

        for(int i = minIndex; i < maxIndex; i++){
            for(int j = minIndex; j < maxIndex; j++){
                String s = String.valueOf(i*j);
                for(int k = 0; k < s.length()/2; k++){
                    if(!(s.substring(k,k+1).equals(s.substring(s.length()-k-1,s.length()-k)))){
                        isPalindrome = false;
                        break;
                    }
                }
                if(isPalindrome && ((i*j) > largestPalindrome)) largestPalindrome = i*j;
                isPalindrome = true;
            }
        }

        return largestPalindrome;
    }

}
