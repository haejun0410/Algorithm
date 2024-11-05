n = int(input())

mp, mf, ms, mv = map(int, input().split())
ingredients = [list(map(int, input().split())) for _ in range(n)]

cost = 2147283647


def recursion(idx, a, b, c, d, price, row):
    global cost, answer
    if idx == n:
        if cost == 2147283647:
            cost = -1
        return

    ci = ingredients[idx]
    na, nb, nc, nd = a + ci[0], b + ci[1], c + ci[2], d + ci[3]
    n_price = price + ci[4]
    if na >= mp and nb >= mf and nc >= ms and nd >= mv:
        if n_price < cost:
            cost = n_price
            row.append(idx+1)
            answer = row[:]
    else:
        row.append(idx+1)
        recursion(idx + 1, na, nb, nc, nd, n_price, row)
    if idx+1 in row:
        row.remove(idx+1)
    recursion(idx + 1, a, b, c, d, price, row)


row = []
answer = []

recursion(0, 0, 0, 0, 0, 0, row)

if cost == -1:
    print(cost)
else:
    print(cost)
    print(*answer)
