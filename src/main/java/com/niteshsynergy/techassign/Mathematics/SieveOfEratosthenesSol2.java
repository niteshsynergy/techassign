package com.niteshsynergy.techassign.Mathematics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SieveOfEratosthenesSol2 {
    public static void main(String[] args) {
        int n = 100000;
        long start = System.nanoTime();
        List<Integer> primes = generatePrimes(n);
        long end = System.nanoTime();

        System.out.println("Total primes up to " + n + ": " + primes.size());
        System.out.println("First 10 primes: " + primes.subList(0, 10));
        System.out.println("Execution Time: " + (end - start) / 1_000_000 + " ms");
    }
    public static List<Integer> generatePrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(SieveOfEratosthenesSol2::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    // Trial division check (no loops inside main stream)
    private static boolean isPrime(int num) {
        return IntStream.rangeClosed(2, (int)Math.sqrt(num))
                .noneMatch(div -> num % div == 0);
    }
}
