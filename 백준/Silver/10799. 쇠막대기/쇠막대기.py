commands = list(input())
stack = []
cnt = 0
answer = 0

for command in commands:
    if command == "(":
        stack.append("(")
        cnt += 1
    if command == ")":
        if stack[-1] == "(":
            cnt -= 1
            answer += cnt
            stack.append(command)
        else:
            cnt -= 1
            answer += 1
            stack.append(command)

print(answer)