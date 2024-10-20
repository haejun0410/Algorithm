def count_rectangles_with_perimeter(n, m, p):
    count = 0
    for width in range(1, m + 1):
        for height in range(1, n + 1):
            perimeter = 2 * (width + height)
            if perimeter >= p:
                count += (m - width + 1) * (n - height + 1)
    return count

# 입력 받기
n, m, p = map(int, input().split())

# 결과 계산 및 출력
result = count_rectangles_with_perimeter(n, m, p)
print(result)