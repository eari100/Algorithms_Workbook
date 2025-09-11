#include <string>
#include <vector>

using namespace std;

/**
* @source: https://school.programmers.co.kr/learn/courses/30/lessons/68646 (월간 코드 챌린지 시즌1 > 풍선 터트리기)
 * @classification: two pointer
 * @문제 푼 날짜 (자력으로 풂?): 25.09.11 (O)
 **/
int solution(vector<int> a) {
    int answer = a.size(), l = a[0], r = a[a.size()-1];
    vector<int> check(a.size(), 0); // 2되면 answer 제외
    
    for(int i=1;i<a.size();i++) {
        l = min(l, a[i-1]);
        if(a[i] > l) {
            ++check[i];    
        }
    }
    
    for(int i=a.size()-2;i>=0;i--) {
        r = min(r, a[i+1]);
        if(a[i] > r) {
            ++check[i];
            
            if(check[i] == 2) {
                answer--;
            }
        }
    }
    
    return answer;
}