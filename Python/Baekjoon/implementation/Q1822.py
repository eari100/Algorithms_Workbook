# @source: https://www.acmicpc.net/problem/1822 (차집합)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.11 (X)

A_len, B_len = map(int, input().split())
A = set(map(int, input().split()))
B = set(map(int, input().split()))

C = A-B

if not C:
    print(0)
else:
    A_sorted = sorted(C)
    print(len(C))
    print(' '.join(map(str, A_sorted)))
