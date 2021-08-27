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

        int n = factorDigitLength;

        int upper = (int)Math.pow(10, n) -1;
        int lower = 1 + upper / 10;
        int max = 0;

        for(int i = upper; i >= lower; i--){
            for(int j = i; j >= lower; j--){

                int r = i * j;
                if( r < max)
                    break;

                int number = r;
                int reverse = 0;

                while(number != 0){
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                }

                if(r == reverse && r > max)
                    max = r;
            }
        }
        return max;
    }


    public static void main(String[] args){
        ProblemFour result = new ProblemFour();
        System.out.println(result.largestPalindromicNumber(2));
    }
}
