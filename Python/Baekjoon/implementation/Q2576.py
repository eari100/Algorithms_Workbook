_sum = 0
_min = 100

for _ in range(7):
    x = int(input())
    if x % 2 != 0:
        _sum += x
        _min = min(_min, x)

if _sum != 0:
    print(_sum)
    print(_min)
else:
    print(-1)