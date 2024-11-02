n,m = map(int,input().split())

def recursion(number):

    if number == m:
        print(*arr)
        return

    for i in range(0,n):
        num = num_list[i]
        if arr and num < arr[-1]:
            continue
        arr.append(num_list[i])
        recursion(number+1)
        arr.pop()
arr = []
num_list = list(map(int,input().split()))
num_list.sort()
recursion(0)