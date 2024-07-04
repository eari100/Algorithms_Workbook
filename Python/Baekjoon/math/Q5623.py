# @source: https://www.acmicpc.net/problem/5623 (수열의 합)
# @classification: math
# @문제 푼 날짜 (자력으로 풂?): 24.07.05 (O)
n = int(input())

num_list = [sum(map(int, input().split(' '))) for i in range(n)]
answer = []

if n == 2:
    answer.append(1)
    answer.append(num_list[0] - 1)
else:
    print(sum(num_list))
    av = sum(num_list) // ((n - 1) * 2)
    for num in num_list:
        answer.append((num - av) // (n - 2))

print(' '.join(map(str, answer)))
