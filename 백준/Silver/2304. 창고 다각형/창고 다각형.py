n = int(input())

columns = []

for _ in range(n):
    columns.append(tuple(map(int,input().split())))
columns.sort()

max_height = max([t[1] for t in columns])
answer = 0

for i in range(1, max_height+1):
    left = 0
    right = 0
    for j in range(n):
        # 기둥 높이가 i 이상인 가장 왼쪽 기둥 찾기
        column = columns[j]
        if column[1] >= i:
            left = column[0]
            break
    
    for k in range(n-1,-1,-1):
        column = columns[k]
        # 기둥 높이가 i 이상인 가장 오른쪽 기둥 찾기
        if column[1] >= i:
            right = column[0]
            break
    if right != 0:
        # 위에서 구한 위치를 바탕으로 높이 i에 해당하는 면적 구하기
        answer += (right-left+1)

print(answer)