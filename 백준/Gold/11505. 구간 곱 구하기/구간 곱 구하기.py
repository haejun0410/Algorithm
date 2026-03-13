import sys

input = sys.stdin.read

def solve():
    data = input().split()
    if not data: return
    
    ptr = 0
    n = int(data[ptr]); ptr += 1
    m = int(data[ptr]); ptr += 1
    k = int(data[ptr]); ptr += 1
    
    MODULO = 1_000_000_007

    # 트리의 크기를 2의 거듭제곱 형태로 만들면 Bottom-up이 훨씬 쉬워집니다.
    size = 1
    while size < n:
        size *= 2
    
    tree = [1] * (2 * size) # 곱셈이므로 초기값은 1

    # 리프 노드 채우기
    for i in range(n):
        tree[size + i] = int(data[ptr]) % MODULO
        ptr += 1
    
    # 트리 빌드 (Bottom-up)
    for i in range(size - 1, 0, -1):
        tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MODULO

    # 값 수정 (반복문 방식)
    def update(i, val):
        idx = size + i
        tree[idx] = val % MODULO
        while idx > 1:
            idx //= 2
            tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % MODULO

    # 구간 곱 쿼리 (반복문 방식)
    def query(l, r):
        res = 1
        l += size
        r += size
        while l <= r:
            if l % 2 == 1:
                res = (res * tree[l]) % MODULO
                l += 1
            if r % 2 == 0:
                res = (res * tree[r]) % MODULO
                r -= 1
            l //= 2
            r //= 2
        return res

    results = []
    for _ in range(m + k):
        a = int(data[ptr]); ptr += 1
        b = int(data[ptr]); ptr += 1
        c = int(data[ptr]); ptr += 1
        
        if a == 1:
            update(b - 1, c)
        else:
            results.append(str(query(b - 1, c - 1)))

    sys.stdout.write("\n".join(results) + "\n")

if __name__ == "__main__":
    solve()