import sys
input = sys.stdin.readline

A,B = map(int,input().split())

A -= 1
temp_A = 0
# 1로 나누었을 때의 값 더하기
temp_A += A
for i in range(1,999):
    temp_A += (A//(2**i))*((2**i)-(2**(i-1)))
    
temp_B = 0
# 1로 나누었을 때의 값 더하기
temp_B += B
for i in range(1,999):
    temp_B += (B//(2**i))*((2**i)-(2**(i-1)))
    
print(temp_B - temp_A)