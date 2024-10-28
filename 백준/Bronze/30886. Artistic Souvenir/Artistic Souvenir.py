import math

def min_tile_area(a):
    radius = math.sqrt(a/math.pi)
    side = 2 * radius + 2
    return side * side

a = int(input())
result = min_tile_area(a)
print(result)