# @source: https://www.acmicpc.net/problem/34449 (King Arthur's Round Table)
# @classification: geometry
# @문제 푼 날짜 (자력으로 풂?): 25.10.07 (X)
pi = 3.14159
d = float(input())
w = float(input())
n = int(input())

nec = n * w
cir = pi * d

print("YES" if nec <= cir else "NO")