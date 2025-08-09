#include <string>
#include <vector>
#include <set>

using namespace std;

/**
* @source: https://school.programmers.co.kr/learn/courses/30/lessons/64064 (2019 카카오 개발자 겨울 인턴십 > 불량 사용자)
 * @classification: dfs, bit masking
 * @문제 푼 날짜 (자력으로 풂?): 25.08.09 (O)
 **/
set<int> answer;
int user_check;

void bt(vector<string> user_id, vector<string> banned_id, int bid) {
    if(bid == banned_id.size()) {
        answer.insert(user_check);
        return;
    }

    for(int i=0;i<user_id.size();i++) {
        if(user_check & (1<<i)) continue;
        
        string user = user_id[i];
        string ban = banned_id[bid];

        if(user.size() == ban.size()) {
            bool match = true;

            for(int j=0;j<user.size();j++) {
                if(ban[j] == '*') {
                    continue;
                }

                if(user[j] != ban[j]) {
                    match = false;
                    break; 
                }
            }

            if(match) {
                user_check |= (1<<i);
                bt(user_id, banned_id, bid+1);
                user_check ^= (1<<i);
            }
        }
    }
}

int solution(vector<string> user_id, vector<string> banned_id) {
    user_check = (1 << user_id.size());
    bt(user_id, banned_id, 0);
    
    return answer.size();
}