package com.niteshsynergy.dsa.Week16;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
Developed By Nitesh Synergy on 27-08-2025
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        System.out.println(maxArea(height));
        System.out.println(maxAreaUsedStreamApi(height));
    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h= Math.min(height[left], height[right]);
            int width= right-left;
            int area = h * width;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right])
                left++;
            else
                right--;

        }
        return maxArea;
    }
    public static int maxAreaUsedStreamApi(int[] height) {
        int n = height.length;

        return IntStream.range(0, n)  // i from 0 to n-1
                .boxed() // .boxed() converts each primitive int from the IntStream into an Integer object.
                .flatMap(i -> IntStream.range(i + 1, n)
                        .mapToObj(j -> Math.min(height[i], height[j]) * (j - i)))
                .max(Integer::compare)
                .orElse(0);
    }
}

/*
Technique Used → Two Pointers

Start with two pointers: left = 0, right = n-1.

Calculate area:
area = min(height[left], height[right]) * (right - left)

Update max area.

Move the pointer with smaller height (because it limits the area).

Continue until left < right.

Time Complexity: O(n)
Space Complexity: O(1)
 */
