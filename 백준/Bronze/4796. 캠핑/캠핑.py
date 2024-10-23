import sys
input = sys.stdin.readline

cnt = 1
while True:
    L,P,V = map(int,input().split())
    if V == 0:
        break
    print("Case {}: {}".format(cnt, L*(V//P) + min(L, V%P)))
    cnt += 1