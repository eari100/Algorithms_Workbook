#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2573 (빙산)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.12.11 (O)
 **/
int n, m, board[300][300], year = 0;
bool visited[300][300];
int dir[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
queue<pair<int, int>> q1;
queue<vector<int>> q2;

int main()
{
    cin>>n>>m;

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            cin>>board[i][j];

            if (board[i][j])
            {
                q1.push({i, j});
            }
        }
    }

    while (q1.size())
    {
        // 두 덩어리 이상인지 확인
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                visited[i][j] = false;
            }
        }

        int cnt = 0;
        queue<pair<int, int>>  q3;
        pair<int, int> f = q1.front();
        q3.push({f.first, f.second});
        visited[f.first][f.second] = true;

        while (q3.size())
        {
            pair<int, int> f3 = q3.front();
            q3.pop();
            cnt++;

            for (int i=0;i<4;i++)
            {
                int x = f3.first + dir[i][0];
                int y = f3.second + dir[i][1];

                if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] && !visited[x][y])
                {
                    visited[x][y] = true;
                    q3.push({x, y});
                }
            }
        }

        if (cnt < q1.size())
        {
            cout<<year;
            return 0;
        }


        while (q1.size())
        {
            pair<int, int> f = q1.front();
            q1.pop();

            int melt = 0;

            for (int i=0;i<4;i++)
            {
                int x = f.first + dir[i][0];
                int y = f.second + dir[i][1];

                if (x >= 0 && x < n && y >= 0 && y < m && !board[x][y])
                {
                    ++melt;
                }
            }

            q2.push({f.first, f.second, melt});
        }

        while (q2.size())
        {
            vector<int> f = q2.front();
            q2.pop();

            board[f[0]][f[1]] = max(board[f[0]][f[1]] - f[2], 0);

            if (board[f[0]][f[1]])
            {
                q1.push({f[0], f[1]});
            }
        }

        ++year;
    }

    cout<<0;
}