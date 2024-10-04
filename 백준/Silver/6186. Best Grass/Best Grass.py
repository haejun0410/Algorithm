def count_grass_clumps(field):
    R = len(field)
    C = len(field[0])
    visited = [[False] * C for _ in range(R)]
    clump_count = 0

    def dfs(i, j):
        if i < 0 or i >= R or j < 0 or j >= C or field[i][j] == '.' or visited[i][j]:
            return
        visited[i][j] = True
        # Check right and down
        dfs(i, j+1)
        dfs(i+1, j)

    for i in range(R):
        for j in range(C):
            if field[i][j] == '#' and not visited[i][j]:
                clump_count += 1
                dfs(i, j)

    return clump_count

R, C = map(int, input().split())
field = [input().strip() for _ in range(R)]

result = count_grass_clumps(field)
print(result)