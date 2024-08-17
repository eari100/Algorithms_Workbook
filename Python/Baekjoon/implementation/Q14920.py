n = int(input())
answer = 0

while n > 1:
    answer += 1

    if n % 2 == 0:
        n /= 2
    else:
        n = 3 * n + 1

print(answer+1)

