N = int(input())
F = int(input())

y = (N // 100) * 100

while y % F != 0:
    y += 1

str_y = str(y)
print(str_y[-2:])
