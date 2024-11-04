def find(s):
    n = len(s) 
    ans = 0
    
    arr = [int(char) for char in s]
    prefix_sum = [0] * (n + 1)
    for i in range(1, n + 1):
        prefix_sum[i] = prefix_sum[i - 1] + arr[i - 1]
        
    
    for length in range(2, n + 1, 2):
        for start in range(n - length + 1):
            mid = start + length // 2
            
            sum_front = prefix_sum[mid] - prefix_sum[start]
            sum_back = prefix_sum[start + length] - prefix_sum[mid]
            
            if sum_front == sum_back:
                ans = max(ans, length)
                
    return ans
                
s = str(input())
print(find(s))