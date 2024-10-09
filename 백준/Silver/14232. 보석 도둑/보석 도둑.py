import sys
input = sys.stdin.readline

k = int(input())

current = 2
jewels = []

# k의 제곱근까지 나눠보면서 소인수를 구함
while current <= int(k**0.5):
    if k % current == 0:
        jewels.append(current)
        k //= current
    else:
        current += 1

if k > 1:
    jewels.append(k)

print(len(jewels))
print(*jewels)