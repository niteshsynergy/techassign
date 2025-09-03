package com.niteshsynergy.OneLakhPlusCode;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemN01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int target = scan.nextInt();
        scan.close();
        System.out.println("Method findPairsSolutionN01 :");
        findPairsSolutionN01(arr, target);
        System.out.println("Method findPairsSolutionN02");
        findPairsSolutionN02(arr, target);

    }
    // In case Array us not sorted.
    public static void findPairsSolutionN01(int[] arr, int target) {
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    System.out.println(" Element Found : "+arr[i]+" "+arr[j]);
                   if(!flag)
                       flag=true;
                    return; // in case more than one sol just remove return statement from here.
                }
            }

        }
        if(!flag){
            System.out.println("Element Not Found");
        }
    }
    // In case of Array going to sort it
    public static void findPairsSolutionN02(int[] arr, int target) {
        // coming soon...
        Arrays.sort(arr);
        boolean flag=false;
        int left=0;
        int right=arr.length-1;
        // maintain two indices pointing to endpoints of the array
        while(left<right){
            if(arr[left]+arr[right]==target){
                System.out.println("Element Found : "+arr[left]+" "+arr[right]);
                if(!flag)
                    flag=true;
                return; // in case more than one sol just remove return statement from here.
            }
            else if(arr[left]+arr[right]<target){
                left++;
            }
            else {
                right--;
            }
        }
        if(!flag){
            System.out.println("Element Not Found");
        }

    }
    public static void findPairsSolutionN03(int[] arr, int target) {
        // coming soon..
    }
}

/*
Find a pair with the given sum in an array
Input: nums = [8, 7, 2, 5, 3, 1] target = 10
Output: Pair found (8, 2)orPair found (7, 3)
Input: nums = [5, 2, 6, 8, 1, 9] target = 12
Output: Pair not found
 */