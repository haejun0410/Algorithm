t = int(input())

def recursion(idx, cost, score):
    global max_score
    if idx == n:
        if score > max_score:
            max_score = score
        return
    ## 먹는다
    new_cost = cost + ingredients[idx][1]
    new_score = score + ingredients[idx][0]
    if new_cost <= l:
        recursion(idx+1, new_cost, new_score)
    recursion(idx+1, cost, score)
    ## 먹지 않는다.

for test_case in range(1, t+1):
    n, l = map(int, input().split())

    ingredients = [list(map(int, input().split())) for _ in range(n)]
    max_score = 0
    recursion(0, 0, 0)
    print("#{} {}".format(test_case, max_score))
