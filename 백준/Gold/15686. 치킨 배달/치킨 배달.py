n, m = map(int, input().split())
INF = int(1e9)

stores = []
homes = []

for i in range(n):
    arr = list(map(int, input().split()))
    for j in range(n):
        if arr[j] == 2:
            stores.append((i, j))
        if arr[j] == 1:
            homes.append((i, j))


def recursion(idx, row, cnt):
    global cost

    if cnt == m or (idx == len(stores) and cnt < m):
        # 치킨 거리 계산하기
        current_cost = 0
        for home in homes:
            distance = INF
            for target in range(len(row)):
                # 폐업되지 않은 가게들로 치킨 거리 계산
                if row[target] == 1:
                    hy, hx = home
                    cy, cx = stores[target]
                    distance = min(distance, (abs(cy-hy) + abs(cx-hx)))
            current_cost += distance
        cost = min(current_cost, cost)
        return

    new_row = row[:]
    # 폐업 시킴
    recursion(idx + 1, new_row, cnt)
    # 폐업 시키지 않음
    new_row[idx] = 1
    recursion(idx + 1, new_row, cnt + 1)



cost = INF
recursion(0, [0]*len(stores), 0)
print(cost)