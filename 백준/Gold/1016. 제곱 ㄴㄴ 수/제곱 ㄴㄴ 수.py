import sys
input = sys.stdin.readline

min,max = map(int,input().split())

num_list = [1] * (max-min+1)

for i in range(2,1000000):
    square = i**2
    a = (min-1)//square+1
    b = (max)//square
    for k in range(a,b+1):
        num_list[k*square-min] = 0

print(sum(num_list))
