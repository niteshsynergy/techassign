package com.niteshsynergy.dsa.Week16;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array size: ");
        int n= sc.nextInt();
        System.out.println("Enter the ele number: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1; // length of unique elements
    }
    public static int removeDuplicatesStreamApi(int[] nums) {
        // Get distinct values using Stream API
        int[] unique = Arrays.stream(nums).distinct().toArray();

        // Copy unique values back into nums (no manual loop)
        System.arraycopy(unique, 0, nums, 0, unique.length);

        return unique.length; // count of unique elements
    }

}
