#include <vector>
#include <stack>

using namespace std;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/131704 (택배상자)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.30 (O)
 **/
stack<int> stk;

int solution(vector<int> order) {
    int answer = 0, index = 0;
    
    for(int i=1;i<=order.size();i++) {
        if(order[index] == i) {
            answer++;
            index++;
        } else {
            while(stk.size()) {
                int t = stk.top();

                if(t == order[index]) {
                    stk.pop();
                    index++;
                    answer++;
                } else {
                    break;
                }
            }
            
            stk.push(i);
        }
    }
    
    while(stk.size()) {
        int t = stk.top();
        
        if(t == order[index]) {
            stk.pop();
            index++;
            answer++;
        } else {
            break;
        }
    }
    
    return answer;
}