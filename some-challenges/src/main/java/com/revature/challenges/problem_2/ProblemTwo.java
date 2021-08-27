package com.revature.challenges.problem_2;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
    Problem Description:

        Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting
        with 1 and 2, the first 10 terms will be:

            1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

        By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the
        sum of the even-valued terms up to index "n" of the sequence.

        Constraints:

            1 < n <= 91

 */
public class ProblemTwo {
    public static Map<Integer,Long> fibMap = new HashMap<>();

    public long fibSeq(int exclusiveEnd){
        if (fibMap.containsKey(exclusiveEnd))
            return fibMap.get(exclusiveEnd);
        if (fibMap.containsKey(exclusiveEnd-1) && fibMap.containsKey(exclusiveEnd-2))
        {
            long eF = fibMap.get(exclusiveEnd-1) + fibMap.get(exclusiveEnd-2);
            fibMap.put(exclusiveEnd, eF);
            return eF;
        }
        else
        {
            return (fibSeq(exclusiveEnd-1) + fibSeq(exclusiveEnd-2));
        }
    }
    public long sumEvenFibNumbers(int exclusiveEnd) {
        fibMap.put(0, (long) 0);
        fibMap.put(1, (long) 1);
        fibSeq(exclusiveEnd+1);
        long answer = 0;
        for(int i=3; i<exclusiveEnd; i+=3)
        {
            answer += fibMap.get(i);
        }
        return answer;
    }
}
