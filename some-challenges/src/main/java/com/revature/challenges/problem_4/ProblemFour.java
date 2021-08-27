package main.java.com.revature.challenges.problem_4;

/*
    Problem Description:

        A palindromic number reads the same both ways. The largest palindrome made from the product of
        two 2-digit numbers is 9009 = 91 × 99.

        Find the largest palindrome made from the product of two numbers whose digit length is "n".

    Constraints:

        1 <= n <= 4

 */

public class ProblemFour {

    public ProblemFour(){

    }

    public int largestPalindromicNumber(int factorDigitLength) {
        int num = 0, reverse = 0, result = 0;
        if(factorDigitLength == 1){
            for(int i = 0; i <= 9; i++){
                for(int j = 0; j <= 9; j++){
                    num = j * i;
                    while(num != 0)
                    {
                        int remainder = num % 10;
                        reverse = reverse * 10 + remainder;
                        num = num/10;
                    }
                    if(reverse == (j * i)){
                        result = reverse;
                    }
                    reverse = 0;
                    num = 0;
                }
            }
        }
        else if(factorDigitLength == 2){
            for(int i = 0; i <= 99; i++){
                for(int j = 0; j <= 99; j++){
                    num = j * i;
                    while(num != 0)
                    {
                        int remainder = num % 10;
                        reverse = reverse * 10 + remainder;
                        num = num/10;
                    }
                    if(reverse == (j * i)){
                        result = reverse;
                    }
                    reverse = 0;
                    num = 0;
                }
            }
        }
        else if(factorDigitLength == 3){
            for(int i = 0; i <= 999; i++){
                for(int j = 0; j <= 999; j++){
                    num = j * i;
                    while(num != 0)
                    {
                        int remainder = num % 10;
                        reverse = reverse * 10 + remainder;
                        num = num/10;
                    }
                    if(reverse == (j * i)){
                        result = reverse;
                    }
                    reverse = 0;
                    num = 0;
                }
            }
        }
        else if(factorDigitLength == 4){
            for(int i = 0; i <= 9999; i++){
                for(int j = 0; j <= 9999; j++){
                    num = j * i;
                    while(num != 0)
                    {
                        int remainder = num % 10;
                        reverse = reverse * 10 + remainder;
                        num = num/10;
                    }
                    if(reverse == (j * i)){
                        result = reverse;
                    }
                    reverse = 0;
                    num = 0;
                }
            }
        }
        else{
            result = 0;
        }
        return result;
    }

}
