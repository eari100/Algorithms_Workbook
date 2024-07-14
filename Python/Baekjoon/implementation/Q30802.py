# @source: https://www.acmicpc.net/problem/30802 (웰컴 키트)
# @classification: implementation
# @문제 푼 날짜 (혼자 힘으로 풂?): 24.07.14 (O)
n = int(input())
t_size_list = list(map(int, input().split()))
t, p = map(int, input().split())

t_cnt, p_set_cnt, p_one_cnt = 0, 0, 0

for t_size in t_size_list:
    t_cnt += t_size // t

    if t_size % t > 0:
        t_cnt += 1

p_set_cnt = n // p
p_one_cnt = n % p

print(t_cnt)
print(p_set_cnt, p_one_cnt)
