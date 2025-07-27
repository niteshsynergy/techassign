package com.niteshsynergy.techassign.Mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenesSol1 {
    //Implement and analyze Sieve of Eratosthenes for primes up to 10⁵
    public static void main(String[] args) {

        int n = 100000;

        long startTime = System.nanoTime();
        List<Integer> primes = generatePrimes(n);
        long endTime = System.nanoTime();

        System.out.println("Total primes up to " + n + ": " + primes.size());
        System.out.println("First 10 primes: " + primes.subList(0, 10));
        System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");

    }
    public static List<Integer> generatePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);  // Collect prime immediately
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return primes;
    }
}