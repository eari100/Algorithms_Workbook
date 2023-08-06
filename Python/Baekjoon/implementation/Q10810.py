N, M = map(int, input().split())
_list = [0] * N

for _ in range(M):
    i, j, k = map(int, input().split())

    for idx in range(i-1, j):
        _list[idx] = k

print(*_list)