import sys
input = sys.stdin.readline

gcd,lcm= map(int,input().split())

maxg = gcd*lcm

def _gcd(a, b):
    while a % b != 0 : 
        tmp = a % b
        a = b
        b = tmp
    return b

def _lcm(a,b):
    return a*b//gcd

answer = []

for i in range(gcd, int(maxg**0.5) + 1, gcd):
    if _gcd(i, (maxg//i)) == gcd:
        if _lcm(i, (maxg//i)) == lcm:
            answer.append((i,maxg//i))

print(*answer[-1])