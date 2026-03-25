from collections import deque

n = int(input())

word = list("SciComLove")
deq = deque();
for i in word:
    deq.append(i)

for i in range(n%10):
    temp = deq.popleft()
    deq.append(temp)

print(''.join(deq))
