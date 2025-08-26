def trap(height):
    left, right = 0, len(height) - 1
    leftMax, rightMax = 0, 0
    water = 0

    while left < right:
        if height[left] < height[right]:
            if height[left] >= leftMax:
                leftMax = height[left]
            else:
                water += leftMax - height[left]
            left += 1
        else:
            if height[right] >= rightMax:
                rightMax = height[right]
            else:
                water += rightMax - height[right]
            right -= 1

    return water

# Example
print("Two Pointers:", trap([4, 2, 0, 3, 2, 5]))


def trap_stream(height):
    n = len(height)
    if n == 0:
        return 0

    leftMax = [0] * n
    rightMax = [0] * n

    # Compute leftMax
    leftMax[0] = height[0]
    for i in range(1, n):
        leftMax[i] = max(leftMax[i-1], height[i])

    # Compute rightMax
    rightMax[n-1] = height[n-1]
    for i in range(n-2, -1, -1):
        rightMax[i] = max(rightMax[i+1], height[i])

    # Pythonic: sum using list comprehension
    return sum(min(leftMax[i], rightMax[i]) - height[i] for i in range(n))

# Example
print("Stream-like Python:", trap_stream([4, 2, 0, 3, 2, 5]))

