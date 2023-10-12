# @source: https://www.acmicpc.net/problem/10431 (줄세우기)
# @classification: bubble sort
# @문제 푼 날짜 (자력으로 풂?): 23.10.12 (X)

def bubble_sort(students):
    back_count = 0

    for i in range(0, len(students)-1):
        for j in range(i+1, len(students)):
            if students[i] > students[j]:
                students[i], students[j] = students[j], students[i]
                back_count += 1

    return back_count


test_count = int(input())

for i in range(1, test_count+1):
    _input = list(map(int, input().split()))
    students = _input[1:]
    print(i, bubble_sort(students))
