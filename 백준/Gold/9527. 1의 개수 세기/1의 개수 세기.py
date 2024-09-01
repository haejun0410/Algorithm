import sys
input = sys.stdin.readline

x,y = map(int,input().split())

def func(n):
    count = 0
    k = 0

    while 2**k <= n:
        p = 2**(k+1)
        p_count = (n+1)//p

        count += p_count * (p//2)

        left = (n+1) % p
        count += max(0, left - p//2)

        k += 1
    return count

print(func(y) - func(x-1))