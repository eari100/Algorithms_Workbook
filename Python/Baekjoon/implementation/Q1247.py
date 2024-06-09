for i in range(3):
    n = int(input())
    _sum = sum(int(input()) for _ in range(n))

    if _sum == 0: print(0)
    elif _sum > 0: print('+')
    elif _sum < 0: print('-')