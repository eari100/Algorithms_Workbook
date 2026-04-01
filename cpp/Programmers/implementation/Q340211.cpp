#include <vector>

using namespace std;

int solution(vector<vector<int>> points, vector<vector<int>> routes) {
    int answer = 0;
    vector<int> target(routes.size(), 0);
    vector<vector<int>> robots(routes.size());
    vector<int> finish(routes.size(), 0);

    for(int i=0;i<routes.size();i++) {
        robots[i] = points[routes[i][0]-1];
    }

    while(1) {
        bool loop_break = true;

        for(int i=0;i<finish.size();i++) {
            if( !finish[i] ) {
                loop_break = false;
                break;
            }
        }

        if(loop_break) {
            break;
        }

        // 충돌 보드
        int board[100+1][100+1];

        for(int i=1;i<=100;i++) {
            for(int j=1;j<=100;j++) {
                board[i][j] = 0;
            }
        }

        for(int i=0;i<robots.size();i++) {
            if(finish[i]) {
                continue;
            }

            if(board[robots[i][0]][robots[i][1]] == 1) {
                ++answer;
            }

            board[robots[i][0]][robots[i][1]]++;

            int routes_idx = routes[i][target[i]]-1;
            vector<int> point = points[routes_idx];

            if(point[0] == robots[i][0] && point[1] == robots[i][1]) {
                target[i]++;

                if(target[i] == routes[i].size()) {
                    finish[i] = 1;
                }
            }

            // 이동
            if( !finish[i] ) {
                int routes_idx = routes[i][target[i]]-1;
                vector<int> point = points[routes_idx];

                // 같은 목적이 연속으로 일어나지 않으니까 따로 조건문을 쓸 필요없음
                if(robots[i][0] != point[0]) {
                    if(robots[i][0] < point[0]) {
                        robots[i][0]++;
                    } else {
                        robots[i][0]--;
                    }
                } else {
                    if(robots[i][1] < point[1]) {
                        robots[i][1]++;
                    } else {
                        robots[i][1]--;
                    }
                }
            }
        }
    }

    return answer;
}