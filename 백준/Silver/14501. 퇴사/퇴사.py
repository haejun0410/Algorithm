n = int(input())

counsels = [list(map(int, input().split())) for _ in range(n)]

answers = []


def recursion(idx, money):
    if idx == n:
        answers.append(money)
        return

    counsel = counsels[idx]
    if idx+counsel[0] <= n:
        recursion(idx+counsel[0], money + counsel[1])
    recursion(idx + 1, money)


recursion(0, 0)
print(max(answers))