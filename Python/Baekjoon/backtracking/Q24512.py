# @source: https://www.acmicpc.net/problem/24512 (Bottleneck Travelling Salesman Problem (Small))
# @classification: backtracking
# @문제 푼 날짜 (자력솔): 24.07.30 (X)
n, m = map(int, input().split())
_map = [[0] * (n + 1) for _ in range(n + 1)]
inf = 5_000_000 + 1
total_min_cost = inf
match_history_list = []

def bt(node_cnt, depth, history_list, str_index, visited, min_cost):
    history_list[depth] = str_index

    if depth == node_cnt-1:
        end_index = history_list[0]

        if _map[str_index][end_index] > 0:
            cost = _map[str_index][end_index]
            min_cost = max(min_cost, cost)

            global total_min_cost, match_history_list

            if min_cost < total_min_cost:
                total_min_cost = min_cost
                match_history_list = history_list[:]

        return

    for next_node in range(1, node_cnt+1):
        if not visited[next_node] and _map[str_index][next_node] > 0:
            visited[next_node] = True
            cost = _map[str_index][next_node]
            bt(node_cnt, depth+1, history_list, next_node, visited, max(min_cost, cost))
            visited[next_node] = False

for _ in range(m):
    u, v, c = map(int, input().split())
    _map[u][v] = c

for i in range(1, n+1):
    visited = [False] * (n + 1)
    visited[i] = True
    bt(n, 0, [0] * n, i, visited, 0)

if total_min_cost == inf:
    print(-1)
else:
    print(total_min_cost)
    print(' '.join(map(str, match_history_list)))
