#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14442 (벽 부수고 이동하기 2)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.10.29 (O)
 **/
int n, m, k, board[1000][1000], dp[1000][1000][10+1], moves[4][2] = {{-1,0}, {0, 1}, {1, 0}, {0, -1}}, INF = 1000005, min_cost = INF;
queue<vector<int>> q;
string str;

int main()
{
    cin>>n>>m>>k;
    cin>>str;
    for (int i=0;i<n;i++)
    {
        getline(cin, str);
        for (int j=0;j<m;j++)
        {
            board[i][j] = str[j] == '1';
        }
    }

    for (int i=0;i<k;i++)
    {
        dp[0][0][i] = 1;
    }

    q.push({0, 0, k, 1}); // x, y, wall, cost

    while (q.size())
    {
        vector<int> f = q.front();
        q.pop();

        for (int i=0;i<4;i++)
        {
            int x = f[0] + moves[i][0];
            int y = f[1] + moves[i][1];

            if (x < 0 || x >= n || y < 0 || y >= m)
            {
                continue;
            }

            if ( !board[x][y] )
            {
                if ( !dp[x][y][f[2]] )
                {
                    dp[x][y][f[2]] = f[3]+1;
                    q.push({x, y, f[2], f[3]+1});
                }
            }
            else // 벽
            {
                if (f[2] && !dp[x][y][f[2]-1])
                {
                    dp[x][y][f[2]-1] = f[3]+1;
                    q.push({x, y, f[2]-1, f[3]+1});
                }
            }
        }
    }

    for (int i=0;i<=k;i++)
    {
        if (dp[n-1][m-1][i])
        {
            min_cost = min(min_cost, dp[n-1][m-1][i]);
        }
    }

    cout << (min_cost == INF ? -1 : min_cost);
}