package com.niteshsynergy.dsa.Week16;

import java.util.Scanner;
/*
Developed By Nitesh Synergy on 27-08-2025
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size Of Rain Water: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("Enter array "+n+ "elements for Rain Water: ");
        for (int i = 0; i < n; i++)
            height[i] = sc.nextInt();
        System.out.print("Welcome to Rain Water Trap Solver By Nitesh Synergy");
        System.out.println("Trapped Water: " + trap(height));
    }
    public static int trap(int[] height) {

        int left = 0, right = height.length - 1;
        int water=0;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= leftMax)
                    leftMax = height[left];
                else
                    water += leftMax - height[left];
                left++;
            }
            else {
                if(height[right] >= rightMax)
                    rightMax = height[right];
                else
                    water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}

/*
Technique Used → Two Pointers

Maintain two pointers: left and right.

Track maximum height seen so far from left side (leftMax) and from right side (rightMax).

Water at index i is bounded by the smaller of the two maxes.

Always move the pointer with the smaller height, because that side determines the water trapped.

This avoids creating extra leftMax[] and rightMax[] arrays (optimized approach).
 */