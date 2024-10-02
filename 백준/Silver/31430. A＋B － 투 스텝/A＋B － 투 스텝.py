def gab(A, B):
    total = A + B
    encoded = ''
    for i in range(13):
        digit = total % 26
        encoded = chr(ord('a') + digit) + encoded
        total //= 26
    return encoded

def eul(encoded_string):
    total = 0
    for char in encoded_string:
        total = total * 26 + (ord(char) - ord('a'))
    return total

T = int(input())
if T == 1:
    A, B = map(int, input().split())
    encoded = gab(A, B)
    print(encoded)
elif T == 2:
    encoded_string = input()
    result = eul(encoded_string)
    print(result)