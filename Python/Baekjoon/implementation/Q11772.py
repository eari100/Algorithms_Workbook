n = int(input())
sum = 0

for _ in range(n):
    num = input()
    a = num[:-1]
    b = num[-1]
    sum += int(a) ** int(b)

print(sum)