# @source: https://www.acmicpc.net/problem/1837 (암호제작)
# @classification: bruteforce
# @문제 푼 날짜 (자력솔): 24.07.30 (X)
l, k = map(int, input().split())
GOOD = 'GOOD'
BAD = 'BAD'
for p in range(2, k):
    if l % p == 0:
        print(BAD, p)
        break
else:
    print(GOOD)
