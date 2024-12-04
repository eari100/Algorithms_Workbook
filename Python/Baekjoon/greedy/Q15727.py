# @source: https://www.acmicpc.net/problem/15727 (조별과제를 하려는데 조장이 사라졌다)
# @classification: greedy
# @문제 푼 날짜 (자력으로 풂?): 24.12.04 (O)
# todo: greedy 풀이는 비효율적 사칙연산으로 풀 것
dist = int(input())
time = 0

for i in range(5, 0, -1):
    time += dist // i
    dist %= i

print(time)
