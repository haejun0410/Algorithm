import sys

m = int(input())

result = 0
sum = 0
for _ in range(m):
    command = list(map(int, sys.stdin.readline().rstrip("\n").split()))
    if command[0] == 1:
        result = result ^ command[1]
        sum += command[1]
    elif command[0] == 2:
        result = result ^ command[1]
        sum -= command[1]
    elif command[0] == 3:
        print(sum)
    else:
        print(result)