import sys
input = sys.stdin.readline

n = int(input())

nums = list(map(int,input().split()))
nums.sort()

def _gcd(a,b):
    while a%b != 0:
        tmp = a%b
        a = b
        b = tmp
    return b

cnt = 0

for i in range(0,n-1):
    if _gcd(nums[i], nums[i+1]) != 1:
        for j in range(nums[i], nums[i+1]):
            flag = True
            if _gcd(nums[i], j) == 1:
                if _gcd(j, nums[i+1]) == 1:
                    cnt += 1
                    flag = False
                    break
        if flag:
            cnt += 2
print(cnt)