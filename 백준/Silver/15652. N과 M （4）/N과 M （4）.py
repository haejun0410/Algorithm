import itertools

n,m = map(int,input().split())

num_list = [i for i in range(1,n+1)]

npr = itertools.combinations_with_replacement(num_list, m)

for i in list(npr):
    for j in i:
        print(j, end = " ")
    print()