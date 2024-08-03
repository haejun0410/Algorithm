def strToInt(character):
    int = ord(character)
    result = int - 96
    return result

n = int(input())
string = input()

answer = 0
for i in range(n):
    character = string[i]
    hash_num = strToInt(character)
    answer += (hash_num)*31**(i)
print(answer%1234567891)