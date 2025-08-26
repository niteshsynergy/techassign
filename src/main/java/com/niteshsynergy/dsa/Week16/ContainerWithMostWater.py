
def maxArea(height):
    left, right = 0, len(height) - 1
    max_area = 0

    while left < right:
        h = min(height[left], height[right])
        width = right - left
        max_area = max(max_area, h * width)

        # Move smaller height
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_area

# Example
print("Max Area:", maxArea([1,8,6,2,5,4,8,3,7]))

#Complexity: O(n²) — not good for interviews, only for demonstration.
def maxArea_bruteforce(height):
    n = len(height)
    return max(min(height[i], height[j]) * (j - i)
               for i in range(n) for j in range(i+1, n))

print("Max Area (Brute Force):", maxArea_bruteforce([1,8,6,2,5,4,8,3,7]))

