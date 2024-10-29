t = int(input())

def inRange(x,y,n,m):
    return 0 <= x+m-1 < n and 0 <= y+m-1 < n

for test_case in range(1, t+1):
    n,m = map(int,input().split())
    prefix_list = []
    for i in range(n):
        numbers = list(map(int,input().split()))
        row = [0]
        temp = 0
        for number in numbers:
            temp += number
            row.append(temp)
        prefix_list.append(row)
        
    answer = -1
    for x in range(n): 
        for y in range(n):
            if inRange(x,y,n,m):
                current = 0
                for k in range(y,y+m):
                    current += (prefix_list[k][x+m] - prefix_list[k][x])  
                if current > answer:
                    answer = current
    print("#{} {}".format(test_case, answer))