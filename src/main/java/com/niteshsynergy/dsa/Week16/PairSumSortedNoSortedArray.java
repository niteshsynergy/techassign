package com.niteshsynergy.dsa.Week16;

import java.util.*;
import java.util.stream.IntStream;

/*
Developed By Nitesh Synergy on 27-08-2025
 */
public class PairSumSortedNoSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter Target Element: ");
        int target = sc.nextInt();

    }
    public static boolean pairSumSortedArray(int[] arr, int target) {
        // assume here Array is sorted.

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if(sum==target)
                return true;
            else if(sum>target)
                right--;
            else
                left++;
        }
        return false;
    }
    public static boolean hasPairWithSumStreamApi(int[] arr, int target) {
        int n = arr.length;

        return IntStream.range(0, n)  // i from 0 to n-1
                .anyMatch(i ->
                        IntStream.range(i + 1, n)  // j from i+1 to n-1
                                .anyMatch(j -> arr[i] + arr[j] == target)
                );
    }
    public static boolean hasPairWithSumStreamApiWithSet(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        return Arrays.stream(arr)
                .anyMatch(num -> {
                    if (seen.contains(target - num)) {
                        return true;
                    }
                    seen.add(num);
                    return false;
                });
    }
    public static boolean hasPairWithSumUsingStreamWithBoxedFlatMap(int[] arr, int target) {
        int n = arr.length;

        return IntStream.range(0, n)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, n)
                        .mapToObj(j -> arr[i] + arr[j]))
                .anyMatch(sum -> sum == target);
    }
    public static boolean hasPairWithSumUsingStreamHashMap(int[] arr, int target) {
        Map<Integer, Integer> freq = new HashMap<>();

        return Arrays.stream(arr).anyMatch(num -> {
            int complement = target - num;
            if (freq.getOrDefault(complement, 0) > 0) {
                return true;
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            return false;
        });
    }
    // HashSet Approach (O(n), works for unsorted arrays too)
    public static boolean hasPairWithSumUsingHashSet(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true; // found pair
            }
            seen.add(num);
        }
        return false;
    }
    //HashMap Approach (O(n), handles duplicates well)
    public static boolean hasPairWithSumUseHashMapWithDuplicate(int[] arr, int target) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;
            if (freq.getOrDefault(complement, 0) > 0) {
                return true; // found complement
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return false;
    }
//Brute Force Approach (O(n²))
    public static boolean hasPairWithSumBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
