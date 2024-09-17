import sys
input = sys.stdin.readline
import math

n = int(input())

cnt = 1

while(cnt**2 <= n):
    cnt += 1

print(cnt - 1)