# @source: https://www.acmicpc.net/problem/23972 (악마의 제안)
# @classification: math
# @문제 푼 날짜 (자력으로 풂?): 25.08.13 (O)
k, n = map(int, input().split())

if n == 1:
    print(-1)
else:
    y = (n * k) // (n - 1)
    if (n * k) % (n - 1):
        print(y+1)
    else:
        print(y)