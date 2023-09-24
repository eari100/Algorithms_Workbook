num_list = ['D', 'C', 'B', 'A', 'E']

for _ in range(3):
    print(num_list[sum(list(map(int, input().split())))])
