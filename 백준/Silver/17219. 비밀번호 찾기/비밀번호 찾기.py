import sys

n,m = map(int,input().split())
password_dict = {}
for _ in range(n):
    site,pw = sys.stdin.readline().rstrip("\n").split()
    password_dict[site] = pw

for _ in range(m):
    site = sys.stdin.readline().rstrip("\n")
    print(password_dict[site])
