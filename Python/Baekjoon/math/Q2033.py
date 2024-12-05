# @source: https://www.acmicpc.net/problem/2033 (반올림)
# @classification: math
# @문제 푼 날짜 (자력으로 풂?): 24.12.06 (X)
n = int(input())
digit = 10

while digit < n:
    mod = n % digit

    if mod >= digit // 2:
        n += digit

    n -= mod
    digit *= 10

print(n)
