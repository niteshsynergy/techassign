package com.niteshsynergy.dsa.Week16;

import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.stream.*;

/*
Developed By Nitesh Synergy on 27-08-2025
 */
public class ThreeSumTripletSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(threeSumUseStreamApi(arr));

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    /*
    Time Complexity → O(n³) (much worse than two-pointer O(n²)).
    Space Complexity → Higher due to generating all triplets first.
    Readable but not efficient.
     */
    public static List<List<Integer>> threeSumUseStreamApi(int[] nums) {
        int n = nums.length;
        return IntStream.range(0, n)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, n)
                        .boxed()
                        .flatMap(j -> IntStream.range(j + 1, n)
                                .mapToObj(k -> Arrays.asList(nums[i], nums[j], nums[k]))))
                .filter(triplet -> triplet.stream().mapToInt(Integer::intValue).sum() == 0)
                .map(triplet -> {
                    List<Integer> sorted = new ArrayList<>(triplet);
                    Collections.sort(sorted);
                    return sorted;
                })
                .distinct() // remove duplicates
                .collect(Collectors.toList());
    }
}
