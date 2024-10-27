# @source: https://www.acmicpc.net/problem/28063 (동전 복사)
# @classification: ad-hoc
# @문제 푼 날짜 (자력으로 풂?): 24.10.27 (X)
n = int(input())
x, y = map(int, input().split())

if n == 1:
    print(0)
elif (x == 1 or x == n) and (y == 1 or y == n):
    print(2)
elif x == 1 or x == n or y == 1 or y == n:
    print(3)
else:
    print(4)
