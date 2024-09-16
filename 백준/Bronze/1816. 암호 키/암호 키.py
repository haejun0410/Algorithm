import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    num = int(input())
    flag = False
    for i in range(2,1000001):
        if num %i == 0:
            flag = True
            break
    print("NO" if flag else "YES")