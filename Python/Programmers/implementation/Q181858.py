# @source: https://school.programmers.co.kr/learn/courses/30/lessons/181858 (무작위로 K개의 수 뽑기
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.10 (O)
def solution(arr, k):
    answer = []
    arr_index = 0

    while len(answer) < k:
        if arr_index < len(arr):
            if arr[arr_index] not in answer:
                answer.append(arr[arr_index])
            arr_index += 1
        else:
            answer.append(-1)

    return answer