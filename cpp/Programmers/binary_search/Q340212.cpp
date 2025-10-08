#include <string>
#include <vector>

using namespace std;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/340212 ([PCCP 기출문제] 2번 / 퍼즐 게임 챌린지)
 * @classification: binary search
 * @문제 푼 날짜 (자력으로 풂?): 25.10.08 (O)
 **/
int solution(vector<int> diffs, vector<int> times, long long limit) {
    int answer = 0;
    int level_s = 1, level_e = 1<<31-1;
    
    while(level_s <= level_e) {
        int level = (level_s + level_e) >> 1;
        long long finish = 0;
        
        for(int i=0;i<diffs.size();i++) {
            if(diffs[i] <= level) {
                finish += times[i];
            } else {
                int cnt = diffs[i] - level;
                finish += cnt * (times[i-1] + times[i]) + times[i];
            }
        }
        
        if(finish <= limit) {
            answer = level;
            level_e = level-1;
        } else {
            level_s = level+1;
        } 
    }
    
    return answer;
}