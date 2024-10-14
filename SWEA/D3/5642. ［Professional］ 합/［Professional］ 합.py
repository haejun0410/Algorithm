T = int(input())
for t in range(1, T+1):
    Num = int(input())
    dp = [0]*Num
    nums = list(map(int, input().split()))
    for i in range(Num):
        dp[i] = max(dp[i-1] + nums[i], nums[i])
        
    print("#"+str(t),max(dp))