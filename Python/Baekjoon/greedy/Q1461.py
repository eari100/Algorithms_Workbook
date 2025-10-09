# @source: https://www.acmicpc.net/problem/1461 (도서관)
# @classification: greedy
# @문제 푼 날짜 (자력으로 풂?): 25.10.09 (O)
import heapq


cost, p, n = 0, 0, 0
cnt, power = map(int, input().split())
target = map(int, input().split())
pos, neg = [], []

for num in target:
    if num > 0:
        heapq.heappush(pos, -num)
    else:
        heapq.heappush(neg, num)

if len(pos) > 0:
    p = -pos[0]

if len(neg) > 0:
    n = -neg[0]

repeat = power

if p > n:
    cost += p

    while repeat > 0 and len(pos) > 0:
        heapq.heappop(pos)
        repeat -= 1
else:
    cost += n

    while repeat > 0 and len(neg) > 0:
        heapq.heappop(neg)
        repeat -= 1

while len(pos) > 0:
    cost -= 2 * pos[0]

    for _ in range(power):
        if len(pos) == 0:
            break

        heapq.heappop(pos)

while len(neg) > 0:
    cost -= 2 * neg[0]

    for _ in range(power):
        if len(neg) == 0:
            break

        heapq.heappop(neg)

print(cost)
