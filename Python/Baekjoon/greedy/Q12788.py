# @source: https://www.acmicpc.net/problem/12788 (제 2회 IUPC는 잘 개최될 수 있을까?)
# @classification: greedy
# @문제 푼 날짜 (자력으로 풂?): 24.09.24 (O)
n = int(input())
a, b = map(int, input().split())
target = a * b
pens = sorted(list(map(int, input().split())), reverse=True)
total = 0
index = -1

for i in range(len(pens)):
    total += pens[i]
    if total >= target:
        index = i+1
        break

print("STRESS" if index == -1 else index)
