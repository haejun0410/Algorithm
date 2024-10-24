a,b = map(int,input().split())

print("A" if a >= (b+1)%4 else "B")