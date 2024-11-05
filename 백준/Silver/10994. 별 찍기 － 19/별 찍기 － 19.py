star = int(input()) 
length = (4*star)-3
map_array = [[' ']*(length) for _ in range(length)]

def star_19(n, x, y):
    global map_array
    
    length = (4*n)-3
    if length == 1:
        map_array[x][y] = "*"
        return
    
    else:    
        for i in range(length):
            map_array[x][y+i] = "*" 
            map_array[y+i][x] = "*" 
            map_array[x+(length-1)][y+i] = "*" 
            map_array[x+i][y+(length-1)] = "*" 
        n = n-1
        x = x+2
        y = y+2
        star_19(n, x, y)
        return

star_19(star, 0, 0)
for i in range(length):
    print(*map_array[i], sep = '')