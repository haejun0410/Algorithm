def count_time_with_k(N, K):
    count = 0
    K_str = str(K)
    for hour in range(N + 1):
        for minute in range(60):
            for second in range(60):
                time_string = f'{hour:02d}:{minute:02d}:{second:02d}'
                if K_str in time_string:
                    count += 1
    return count

n, k = map(int, input().split())

print(count_time_with_k(n, k))