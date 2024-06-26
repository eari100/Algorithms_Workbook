# @source: https://www.acmicpc.net/problem/1268 (임시 반장 정하기)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 24.06.07 (X)
n = int(input())
board = [[0] * 5 for _  in range(n)]
score = [[0] * n for _  in range(n)]
_max = 0
max_index = 0

for i in range(n):
    _arr = input().split(' ')
    for j in range(5):
        board[i][j] = int(_arr[j])

for i in range(5):
    for j in range(n):
        a = board[j][i]

        for k in range(j+1, n):
            b = board[k][i]
            if a == b:
                score[j][k] = 1
                score[k][j] = 1

for i in range(n):
    _sum = sum(score[i])
    if _sum > _max:
        _max = _sum
        max_index = i

print(max_index+1)
