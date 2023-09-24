answer = ''

for _ in range(3):
    num_list = list(map(int, input().split()))
    x = 0
    y = 0

    for num in num_list:
        if num == 0:
            x += 1

    if x == 1:
        answer += 'A\n'
    elif x == 2:
        answer += 'B\n'
    elif x == 3:
        answer += 'C\n'
    elif x == 4:
        answer += 'D\n'
    elif x == 0:
        answer += 'E\n'

print(answer)