difficulty = list(map(int, input().split()))
group_cnt = int(input())
_max = 0

for _ in range(group_cnt):
    _eval = [0] * 3
    score = 0

    for _ in range(3):
        a, b, c = map(int, input().split())
        _eval[0] += a
        _eval[1] += b
        _eval[2] += c

    for i in range(3):
        score += (_eval[i] * difficulty[i])

    _max = max(_max, score)

print(_max)
