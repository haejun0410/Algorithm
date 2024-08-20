import sys

# 체스판의 크기를 입력받음
n = int(input())

# 현재 배치한 퀸이 이전에 배치한 퀸들과 충돌하는지 확인
def attack(x):
	for i in range(x):
    	# 같은 열에 있거나, 대각선 상에 있으면 충돌임
    	if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
        	return True
        return False

# start는 현재 놓고 있는 행
def dfs(start):
	global cnt
    모든 행에 퀸을 배치했다면 유효한 배치이므로 cnt 증가
    if start == n:
    	cnt += 1
    else:
    	for i in range(n):
        	row[start] = i
            # 충돌이 없다면 다음 행을 진행
            if not attack(start):
            	dfs(start + 1)

# 각 행에 퀸을 저장할 리스트 초기화
row = [0] * n
# 가능한 가짓수를 세는 변수 초기화
cnt = 0
dfs(0)

print(cnt)
