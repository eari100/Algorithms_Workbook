#include <string>
#include <vector>
#include <queue>

using namespace std;

/**
* @source: https://school.programmers.co.kr/learn/courses/30/lessons/67259 (2020 카카오 인턴십 > 경주로 건설)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.09.05 (X)
 **/
int straight = 100, corner = 500, INF = (1 << 31) - 1;
int moves[4][2] =
{
    {-1,0},{0,1},{1,0},{0,-1}
};

int solution(vector<vector<int>> board) {
    vector<vector<vector<int>>> money(board.size(), vector<vector<int>>(board[0].size(), vector<int>(4,INF)));
    money[0][0] = {0,0,0,0};
    queue<vector<int>> que; // x, y, cost, dir
    que.push({0, 0, 0, -1});
    
    while( !que.empty() )
    {
        vector<int> f = que.front();
        que.pop();
        
        for(int i=0;i<4;i++)
        {
            int x = f[0] + moves[i][0];
            int y = f[1] + moves[i][1];
            int cost = f[2] + straight;
            
            if(f[3] != -1 && f[3] != i)
            {
                cost += corner;
            }

            if(x < 0 || x >= board.size() || y < 0 || y >= board[0].size() || board[x][y]) continue;
            if(money[x][y][i] < cost) continue;
            
            money[x][y][i] = cost;
            que.push({x,y,cost,i});
        }
    }
    
    int _min = INF;
    
    for(int i=0;i<4;i++)
    {
        _min = min(_min, money[board.size()-1][board[0].size()-1][i]);
    }
    
    return _min;
}