# @source: https://www.acmicpc.net/problem/10837 (동전 게임)
# @classification: ad-hoc
# @문제 푼 날짜 (자력으로 풂?): 24.06.27 (X)
# @reference: https://justicehui.github.io/koi/2021/02/27/BOJ10837
k = int(input())
result = []

for _ in range(int(input())):
    m, n = map(int, input().split())
    if m == n:
        result.append(1)
        continue

    remain = k - max(m, n)
    gap = abs(m - n)

    if m > n:
        result.append(1 if gap - remain <= 2 else 0)
    else:
        result.append(1 if gap - remain <= 1 else 0)

for item in result:
    print(item)