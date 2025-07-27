package com.niteshsynergy.techassign.Mathematics;

import java.util.List;

public class SieveOfEratosthenesSol3 {
    public static void main(String[] args) {
        int n = 100000;
        long start = System.nanoTime();
        List<Integer> primes = null;
        long end = System.nanoTime();

        System.out.println("Total primes up to " + n + ": " + primes.size());
        System.out.println("First 10 primes: " + primes.subList(0, 10));
        System.out.println("Execution Time: " + (end - start) / 1_000_000 + " ms");
    }
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

}
