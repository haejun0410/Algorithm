import itertools
import sys

n,m = map(int,input().split())

num_list = list(map(int,sys.stdin.readline().rstrip().split()))
num_list.sort()
npr = itertools.permutations(num_list, m)

for i in list(npr):
    for j in i:
        print(j, end = " ")
    print()