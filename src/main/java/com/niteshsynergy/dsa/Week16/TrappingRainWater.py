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
