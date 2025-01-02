n = int(input())

cnt = 0

for i in range(1, n+1):
    if cnt != 6:
        print(i, end = " ")
        cnt += 1
    if cnt == 6:
        cnt = 0
        print("Go!", end = " ")
        
if cnt != 0:
    print("Go!")