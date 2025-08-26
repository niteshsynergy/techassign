from typing import List

# 1. Two-pointer (for sorted arrays)
def pair_sum_sorted_array(arr: List[int], target: int) -> bool:
    left, right = 0, len(arr) - 1
    while left < right:
        s = arr[left] + arr[right]
        if s == target:
            return True
        elif s > target:
            right -= 1
        else:
            left += 1
    return False


# 2. Brute Force (O(n²))
def has_pair_with_sum_bruteforce(arr: List[int], target: int) -> bool:
    n = len(arr)
    for i in range(n):
        for j in range(i+1, n):
            if arr[i] + arr[j] == target:
                return True
    return False


# 3. HashSet Approach (O(n))
def has_pair_with_sum_hashset(arr: List[int], target: int) -> bool:
    seen = set()
    for num in arr:
        complement = target - num
        if complement in seen:
            return True
        seen.add(num)
    return False


# 4. HashMap Approach (handles duplicates) (O(n))
def has_pair_with_sum_hashmap(arr: List[int], target: int) -> bool:
    freq = {}
    for num in arr:
        complement = target - num
        if freq.get(complement, 0) > 0:
            return True
        freq[num] = freq.get(num, 0) + 1
    return False


# 5. Using Python any() with generator expression (stream-like)
def has_pair_with_sum_generator(arr: List[int], target: int) -> bool:
    return any(arr[i] + arr[j] == target for i in range(len(arr)) for j in range(i+1, len(arr)))


# 6. Functional style using itertools.combinations (brute force but clean)
from itertools import combinations
def has_pair_with_sum_itertools(arr: List[int], target: int) -> bool:
    return any(x + y == target for x, y in combinations(arr, 2))
