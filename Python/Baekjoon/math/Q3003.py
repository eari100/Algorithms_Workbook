def get_a(y, x):
    return y - x


k, q, r, b, kn, p = map(int, input().split())

print(get_a(1, k), get_a(1, q), get_a(2, r), get_a(2, b), get_a(2, kn), get_a(8, p))
