n = int(input())

answer = []
for i in range(1, int(n**(0.5))):
    if n%i == 0:
        answer.append(i)
        answer.append(n//i)

answer.sort()
print(*answer)