t = int(input())


def palindrome(start, end, word):
    while start < end:
        if word[start] != word[end]:
            return False
        else:
            start += 1
            end -= 1
    return True

for test_case in range(1, t+1):
    word = input()
    split_point = (len(word)-1)//2

    sub_word1 = word[:split_point]
    sub_word2 = word[split_point+1:]

    if palindrome(0, len(sub_word1)-1, sub_word1) and palindrome(0, len(sub_word2)-1, sub_word2) and palindrome(0, len(word) -1, word):
        print("#{} {}".format(test_case, "YES"))
    else:
        print("#{} {}".format(test_case, "NO"))

