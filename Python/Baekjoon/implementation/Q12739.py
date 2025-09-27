n, k = map(int, input().split())
board = list(input())

while k > 0:
    next_board = ['a'] * n

    for i in range(n):
        prev, next = i-1, i+1
        if prev == -1:
            prev = n-1
        if next == n:
            next = 0

        if board[prev] == board[i] == board[next] or board[prev] != board[i] != board[next] != board[prev]:
            next_board[i] = 'B'
        else:
            _check = [0, 0, 0]

            if board[prev] == 'R':
                _check[0] += 1
            if board[i] == 'R':
                _check[0] += 1
            if board[next] == 'R':
                _check[0] += 1

            if board[prev] == 'G':
                _check[1] += 1
            if board[i] == 'G':
                _check[1] += 1
            if board[next] == 'G':
                _check[1] += 1

            if board[prev] == 'B':
                _check[2] += 1
            if board[i] == 'B':
                _check[2] += 1
            if board[next] == 'B':
                _check[2] += 1

            if(_check[0] == 2 and _check[1] == 1) or (_check[1] == 2 and _check[2] == 1) or (_check[2] == 2 and _check[0] == 1):
                next_board[i] = 'R'
            else:
                next_board[i]= 'G'
    board = next_board
    k -= 1

_count = [0] * 3

for color in board:
    if color == 'R':
        _count[0] += 1
    elif color == 'G':
        _count[1] += 1
    elif color == 'B':
        _count[2] += 1

print(*_count)