while True:
    _str = input()

    if _str == '#':
        break

    correct = 0

    for c in _str:
        if c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u' or c == 'A' or c == 'E' or c == 'I' or c == 'O' or c == 'U':
            correct += 1

    print(correct)
