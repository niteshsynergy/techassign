package com.niteshsynergy.dsa.Week16;

import java.util.*;
import java.util.stream.*;

public class LongestUniqueSubstringSTream {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int[] left = {0}; // mutable container
        return IntStream.range(0, s.length())
                .map(right -> {
                    while (window.contains(s.charAt(right))) {
                        window.remove(s.charAt(left[0]));
                        left[0]++;
                    }
                    window.add(s.charAt(right));
                    return right - left[0] + 1;
                })
                .max()
                .orElse(0);
    }
}
