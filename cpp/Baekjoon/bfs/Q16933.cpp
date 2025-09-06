#include <iostream>
#include <deque>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16933 (벽 부수고 이동하기 3)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.09.06 (X)
 **/
int h,w,k;
int moves[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};
deque<vector<int>> que; // h,w,k,낮밤,cost
string row;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>h>>w>>k;
    int board[h][w], visited[h][w][k+1];

    for (int i = 0; i < h; i++)
    {
        cin>>row;
        for (int j = 0; j < w; j++)
        {
            board[i][j] = (row[j] == '1');

            for (int kk=0; kk<k+1;kk++) // visited 초기화
            {
                visited[i][j][kk] = 0;
            }
        }
    }

    visited[0][0][k] = 1;
    que.push_back({0,0,k,1,1});

    while (!que.empty())
    {
        vector<int> _front = que.front();
        que.pop_front();

        if (_front[0] == h-1 && _front[1] == w-1)
        {
            cout << _front[4];
            return 0;
        }

        int wb = _front[2], is_day = _front[3], next_cost = _front[4] + 1;

        for (int i=0;i<4;i++) // 이동
        {
            int x = _front[0] + moves[i][0];
            int y = _front[1] + moves[i][1];

            if (x < 0 || x >= h || y < 0 || y >= w) continue;

            if (board[x][y]) // 벽이라면
            {
                if (is_day) // 낮
                {
                    if (wb > 0 && visited[x][y][wb-1] == 0) // 벽을 부술 수 있다면
                    {
                        visited[x][y][wb-1] = 1;
                        que.push_back({x,y,wb-1,0,next_cost});
                    }
                }
                else // 밤
                {
                    if (wb > 0 && visited[x][y][wb-1] == 0)
                    {
                        que.push_back({_front[0], _front[1], wb, 1, next_cost});
                    }
                }
            }
            else // 벽이 아니라면
            {
                if (visited[x][y][wb] == 0)
                {
                    visited[x][y][wb] = 1;
                    que.push_back({x,y,wb,!is_day,next_cost});
                }
            }
        }
    }

    cout << -1;
}
