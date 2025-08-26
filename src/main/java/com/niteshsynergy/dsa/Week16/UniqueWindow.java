package com.niteshsynergy.dsa.Week16;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str= sc.nextLine();
        System.out.println("Result :"+lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

/*
Problem Statement:
Find the length of the longest substring without repeating characters in a given string.

 This is sometimes called the Unique Window problem, because you slide a window that always keeps unique characters inside it.
 */