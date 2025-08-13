package com.niteshsynergy.techassign.slidingWindow;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaxSumSubArrayUsingJava {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print("Enter K size of the array");
        int k = in.nextInt();

        int result= maxSumSubArray(arr,k);
        System.out.println(result);
    }
    public static int maxSumSubArray(int[] arr, int k) {

        if(k>arr.length)
            return -1;
        int windowSum = 0;

        for(int i=0;i<k;i++)
            windowSum += arr[i];
        System.out.println("WindowSum: "+windowSum);
        int maxSum = windowSum;

        for(int end=k;end<arr.length;end++){
            windowSum += arr[end]-arr[end-k];
            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
    public static int maxSumSubArray2(int[] arr, int k) {
        if(k>arr.length)
            return -1;

        return IntStream
                .rangeClosed(0,arr.length-k)
                .map(i-> Arrays.stream(arr,i,i+k).sum()) // sum of each window
                .max()
                .orElse(-1);
    }
}
