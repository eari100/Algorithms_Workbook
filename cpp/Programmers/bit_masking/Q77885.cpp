#include <string>
#include <vector>

using namespace std;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/77885 (2개 이하로 다른 비트)
 * @classification: bit_masking
 * @문제 푼 날짜 (자력으로 풂?): 26.04.07 (X, 규칙을 찾기를 포기하지 말 것. 맞는 것 같은데 안되면 엣지케이스가 존재함)
 **/
vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;

    for(long long number : numbers) {
        long long bit = 1;

        while(number&bit) {
            bit<<=1;
        }

        answer.push_back(number+bit-(bit>>1));
    }

    return answer;
}