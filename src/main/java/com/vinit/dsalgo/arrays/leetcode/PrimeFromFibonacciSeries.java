package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFromFibonacciSeries {

    public static long[] solution(long n) {
        // Type your solution here
        long[] fib = new long[(int)n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int x = 2; x <= n; x++) {
            fib[x] = fib[x - 1] + fib[x - 2];
        }
        System.out.println(Arrays.toString(fib));
        List<Long> result = new ArrayList<>();
        for (long i : fib) {
            if (isPrime(i)) result.add(i);
        }
        System.out.println(Arrays.asList(result));
        long[] res = new long[result.size()];
        int i = 0;
        for (long r : result) {
            res[i] = r;
            i++;
        }
        return res;
    }

    static boolean isPrime(long n)
    {

        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1)));
    }
}
