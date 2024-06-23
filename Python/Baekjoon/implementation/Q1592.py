N, M, L = map(int, input().split())

persons = [0] * N
order = 0
persons[0] = 1

while M > max(persons):
    is_odd = persons[order] % 2 == 0

    if not is_odd:
        order = (order + L) % N
    else:
        order = (order - L) % N

    persons[order] += 1

print(sum(persons) - 1)


