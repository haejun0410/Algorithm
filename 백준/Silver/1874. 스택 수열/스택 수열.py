import sys

num = int(sys.stdin.readline())

stack = []
result = []

current_number = 1
answer = True

for i in range(num):
    data = int(sys.stdin.readline())
    while current_number <= data:
        stack.append(current_number)
        result.append("+")
        current_number += 1


    if stack[-1] == data:
        stack.pop()
        result.append("-")
    else:
        print("NO")
        answer = False
        break

if answer:
    for i in result:
        print(i)