import sys

def csod(n):
    MOD = 1000000
    result = 0
    
    for i in range(2, int(n**0.5) + 1):
        j = n // i
        result += (i + j) * (j - i + 1) // 2
        result %= MOD
        
        if i != j:
            result += i * (n // i - i)
            result %= MOD
    
    return result

n = int(sys.stdin.readline())
print(csod(n))