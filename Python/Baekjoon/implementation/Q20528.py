# @source: https://www.acmicpc.net/problem/20528 (끝말잇기)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 25.09.19 (O)
n = int(input())
words = list(input().split())
correct = 1

for i in range(2, n):
    prev, curr = words[i-1], words[i]
    if prev[0] != curr[0]:
        correct = 0
        break

print(correct)
