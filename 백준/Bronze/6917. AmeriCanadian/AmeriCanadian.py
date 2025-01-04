while True:
    word = input()
    if word == "quit!":
        break
    else:
        if len(word) < 4:
            print(word)
        else:
            if word[-2:] == 'or':
                if word[-3] not in ['a','e','i','o','u','y']:
                    word = word.rstrip('or')+"our"
            print(word)