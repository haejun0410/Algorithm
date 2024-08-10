num_chicken = int(input())
a,b = map(int,input().split())

num = (a//2)+b

print(num_chicken if num>num_chicken else num)