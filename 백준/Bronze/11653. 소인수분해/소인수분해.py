import sys
input = sys.stdin.readline

n = int(input())

div = 2

while n != 1:
    if n%div == 0:
        n = n//div
        print(div)
    else:
        div += 1
