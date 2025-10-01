_list = []
n, m = map(int, input().split())

a = list(map(int, input().split()))
for item in a:
    _list.append(item)

b = list(map(int, input().split()))
for item in b:
    _list.append(item)

_list.sort()

for item in _list:
    print(item, end=' ')