n,m = map(int,input().split())

def recursion(number):

    if number == m:
        print(*arr)
        return

    for i in range(1,n+1):
        if i in arr:
            continue
        arr.append(i)
        recursion(number+1)
        arr.pop()
arr = []
recursion(0)