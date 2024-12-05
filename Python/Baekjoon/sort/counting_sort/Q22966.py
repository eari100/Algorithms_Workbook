
min_hard = 5
min_title = ''

for _ in range(int(input())):
    title, hard = input().split()
    hard = int(hard)

    if hard < min_hard:
        min_hard = hard
        min_title = title

print(min_title)
