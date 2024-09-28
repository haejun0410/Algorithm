import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    a,b = map(int,input().split())
    circular = []

    k = a
    while k%10 not in circular:
        circular.append(k%10)
        k = k*a
    answer = circular[b%(len(circular)) - 1]

    print(10 if answer == 0 else answer)