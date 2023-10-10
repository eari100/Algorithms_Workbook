# @source: https://school.programmers.co.kr/learn/courses/30/lessons/176963 (추억 점수)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.11 (X, dictionary, zip 키워드)

def solution(name, yearning, photo):
    answer = []
    data_dict = dict(zip(name, yearning))

    for humans in photo:
        score = 0

        for human in humans:
            if human in data_dict:
                score += data_dict[human]

        answer.append(score)

    return answer
