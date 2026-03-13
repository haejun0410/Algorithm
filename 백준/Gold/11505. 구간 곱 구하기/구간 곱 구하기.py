import sys

# 빠른 입력을 위한 설정
input = sys.stdin.read

def solve():
    # 전체 데이터를 한 번에 읽어와 토큰화
    data = input().split()
    if not data:
        return
    
    ptr = 0
    n = int(data[ptr]); ptr += 1
    m = int(data[ptr]); ptr += 1
    k = int(data[ptr]); ptr += 1
    
    MODULO = 1_000_000_007

    arr = []
    for _ in range(n):
        arr.append(int(data[ptr]))
        ptr += 1

    # 세그먼트 트리 배열 크기 설정 (4 * n)
    tree = [0] * (4 * n)

    # 1. 트리 구축 (Build)
    def build(node, start, end):
        if start == end:
            tree[node] = arr[start] % MODULO
            return
        
        mid = (start + end) // 2
        build(node * 2, start, mid)
        build(node * 2 + 1, mid + 1, end)
        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MODULO

    # 2. 값 수정 (Update)
    def update(node, start, end, idx, val):
        if start == end:
            tree[node] = val % MODULO
            return
        
        mid = (start + end) // 2
        if idx <= mid:
            update(node * 2, start, mid, idx, val)
        else:
            update(node * 2 + 1, mid + 1, end, idx, val)
        
        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MODULO

    # 3. 구간 곱 계산 (Query)
    def query(node, start, end, l, r):
        # 구간을 벗어난 경우 (곱셈이므로 1 반환)
        if start > r or end < l:
            return 1
        
        # 구간에 완전히 포함된 경우
        if l <= start and end <= r:
            return tree[node]
        
        mid = (start + end) // 2
        left_val = query(node * 2, start, mid, l, r)
        right_val = query(node * 2 + 1, mid + 1, end, l, r)
        
        return (left_val * right_val) % MODULO

    # 트리 초기화
    build(1, 0, n - 1)

    results = []
    # M + K 번의 명령 처리
    for _ in range(m + k):
        a = int(data[ptr]); ptr += 1
        b = int(data[ptr]); ptr += 1
        c = int(data[ptr]); ptr += 1
        
        if a == 1:
            # b번째 수를 c로 바꿈 (인덱스는 0부터 시작하므로 b-1)
            update(1, 0, n - 1, b - 1, c)
        elif a == 2:
            # b부터 c까지의 곱 (인덱스 b-1부터 c-1까지)
            results.append(str(query(1, 0, n - 1, b - 1, c - 1)))

    # 결과 한꺼번에 출력
    sys.stdout.write("\n".join(results) + "\n")

if __name__ == "__main__":
    # 파이썬의 재귀 깊이 제한 해제
    sys.setrecursionlimit(200000)
    solve()