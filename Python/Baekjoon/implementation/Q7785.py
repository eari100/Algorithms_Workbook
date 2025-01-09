# @source: https://www.acmicpc.net/problem/7785 (회사에 있는 사람)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 24.01.09 (O)
n = int(input())

record = {}
for _ in range(n):
    h, a = map(str, input().split())

    if a == 'enter':
        record[h] = h
    else:
        del record[h]

print('\n'.join(sorted(record.keys(), reverse=True)))
