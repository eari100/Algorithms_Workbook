from collections import deque

que = deque([i for i in range(1, int(input())+1)])
answer = []

while len(que) > 1:
    answer.append(que.popleft())
    que.append(que.popleft())

answer.append(que.popleft())

print(" ".join(map(str, answer)))