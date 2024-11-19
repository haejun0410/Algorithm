n = int(input())

arr1 = list(input().split())
arr2 = list(input().split())

a = int(''.join(arr1))
b = int(''.join(arr2))

print(b if a > b else a)