def is_palindrome(meter):
    return meter == meter[::-1]


def palindrometer(meter):
    answer = 0
    fill_zero_num = len(meter)
    
    while True:
        if is_palindrome(meter):
            break
        meter = str(int(meter) + 1).zfill(fill_zero_num)
        
        answer += 1
        
    return answer
        

if __name__ == "__main__":
    while True:
        meter = input()
        
        if meter == "0":
            break
            
        print(palindrometer(meter=meter))