def removeDuplicates(nums):
    if not nums:
        return 0

    i = 0  # slow pointer
    for j in range(1, len(nums)):
        if nums[j] != nums[i]:
            i += 1
            nums[i] = nums[j]
    return i + 1  # length of unique elements

nums = [0,0,1,1,1,2,2,3,3,4]
k = removeDuplicates(nums)
print("Unique Count:", k)
print("Array after removal:", nums[:k])
