# @source: https://www.acmicpc.net/problem/25757 (임스와 함께하는 미니게임)
# @classification: set
# @문제 푼 날짜 (자력으로 풂?): 23.10.13 (O)


cnt, game = input().split()
_set = set(input() for _ in range(int(cnt)))

match_human_cnt = 0

if game == 'Y':
    match_human_cnt = 1
elif game == 'F':
    match_human_cnt = 2
elif game == 'O':
    match_human_cnt = 3

print(len(_set) // match_human_cnt)
