import sys
import copy

n = int(input())

s = set()
for _ in range(n):
    command = sys.stdin.readline().rstrip("\n").split()
    
    if command[0] == 'add':
        s.add(command[1])
    elif command[0] == "remove":
        if command[1] in s:
            s.discard(command[1])
    elif command[0] == "check":
        print(1 if command[1] in s else 0)
    elif command[0] == "toggle":
        if command[1] in s:
            s.discard(command[1])
        else:
            s.add(command[1])
    elif command[0] == "all":
        s = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20'}
    elif command[0] == "empty":
        s = set()