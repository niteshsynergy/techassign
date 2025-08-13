
def max_sum_subarray(arr,k):
    if len(arr)<k:
        return -1;

    window_sum=sum(arr[:k])
    max_sum=window_sum

    for end in range(k,len(arr)):
        window_sum +=arr[end]-arr[end-k];
        max_sum = max(max_sum,window_sum)

    return max_sum

def max_sum_subarray_stream(arr,k):
    if len(arr)<k:
        return -1;

    return max(
        sum(arr[j:j+k])
        for j in range(len(arr)-k+1)
    )

arr=[2,1,5,1,3,2]
k=3
print(f"Max Sum Subarray of size {k} is: {max_sum_subarray(arr, k)}")

print(f"Max Sum Subarray of size {k} (Stream-like) is: {max_sum_subarray_stream(arr, k)}")


