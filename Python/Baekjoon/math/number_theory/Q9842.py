# @source: https://www.acmicpc.net/problem/9842 (Prime)
# @classification: number_theory
# @문제 푼 날짜 (자력으로 풂?): 25.10.07 (O)
_inf = 1000000
is_prime = [True] * (_inf+1)

for i in range(2, _inf+1):
    num = 2*i
    while num <= _inf:
        is_prime[num] = False
        num += i

index = 0

target = int(input())

for i in range(2, _inf+1):
    if is_prime[i]:
        index += 1
        if index == target:
            print(i)
            break