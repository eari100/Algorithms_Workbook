# @source: https://www.acmicpc.net/problem/15552 (빠른 A+B)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.11 (O)

import sys
input = sys.stdin.readline

for _ in range(int(input())):
    a, b = map(int, input().split())
    print(a + b)
