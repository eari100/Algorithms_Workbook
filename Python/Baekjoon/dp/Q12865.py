# @source: https://www.acmicpc.net/problem/12865 (평범한 배낭)
# @classification: knapsack
# @문제 푼 날짜 (자력으로 풂?): 24.07.14 (O)
n, k = map(int, input().split())
data_list = [list(map(int, input().split())) for _ in range(n)]
visited = [False] * n
memo = [0] * (k+1)
max_value = 0

def bt(w_sum, v_sum):
    for i in range(len(data_list)):
        data = data_list[i]

        w_sum2 = w_sum + data[0]
        v_sum2 = v_sum + data[1]

        if not visited[i] and w_sum2 < len(memo) and v_sum2 > memo[w_sum2]:
            global max_value
            max_value = max(max_value, v_sum2)
            memo[w_sum2] = v_sum2

            visited[i] = True
            bt(w_sum2, v_sum2)
            visited[i] = False


bt(0, 0)

print(max_value)
