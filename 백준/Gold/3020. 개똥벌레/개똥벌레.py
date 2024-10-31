import sys
input = sys.stdin.readline

n,h = map(int,input().split())

line = [0 for _ in range(h)]

for i in range(n):
    height = int(input())

    if i%2 == 1:
        line[h - height] += 1
    else:
        line[0] += 1
        line[height] -= 1
prefix = [0 for _ in range(h+1)]

for i in range(h):
    prefix[i+1] = prefix[i] + line[i]

min_destroy = min(prefix[1:])
count = prefix[1:].count(min_destroy)

print("{} {}".format(min_destroy, count))