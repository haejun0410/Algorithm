t = int(input())
for test_case in range(1,t+1):
    nums = list(map(int,input().split()))
    nums.sort()
    
    average = round(sum(nums[1:9])/8)
    print("#{} {}".format(test_case, average))