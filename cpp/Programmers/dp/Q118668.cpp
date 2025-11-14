#include <string>
#include <vector>

using namespace std;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/118668# (코딩 테스트 공부)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.11.14(X)
 **/
int INF = (1<<31)-1, dp[150+5][150+5];

int solution(int alp, int cop, vector<vector<int>> problems) {
    int target_a = 0, target_c = 0;
    
    for(int i=0;i<problems.size();i++) {
        target_a = max(target_a, problems[i][0]);
        target_c = max(target_c, problems[i][1]);
    }
    
    if(alp >= target_a && cop >= target_c) {
        return 0;
    }
    
    for(int i=0;i<=target_a;i++) {
        for(int j=0;j<=target_c;j++) {
            dp[i][j] = INF;
        }
    }
    
    alp = min(alp, target_a);
    cop = min(cop, target_c);
    
    dp[alp][cop] = 0;

    for(int i=alp;i<=target_a;i++) {
        for(int j=cop;j<=target_c;j++) {
            if (dp[i][j] == INF) continue;
            
            if(i+1 <= target_a) {
                dp[i+1][j] = min(dp[i+1][j], dp[i][j] + 1);    
            }
            
            if(j+1 <= target_c) {
                dp[i][j+1] = min(dp[i][j+1], dp[i][j] + 1);    
            } 
            
            for(vector<int> v : problems) {
                if(i >= v[0] && j >= v[1]) {
                    int x = min(i + v[2], target_a);
                    int y = min(j + v[3], target_c);

                    dp[x][y] = min(dp[x][y], dp[i][j] + v[4]);
                }
            }
        }
    }
    
    return dp[target_a][target_c];
}