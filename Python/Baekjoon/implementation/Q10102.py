# @source: https://www.acmicpc.net/problem/10102 (개표)
# @classification: implementation
# @문제 푼 날짜 (자력솔): 25.10.24 (O)
import sys

input = sys.stdin.readline
A, B = 0, 0
n = int(input())
str = input().rstrip()

for c in str:
    if c == 'A':
        A += 1
    else:
        B += 1

if A == B:
    print("Tie")
elif A > B:
    print('A')
else:
    print('B')