#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/13565 (침투)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.10.22 (O)
 **/
int n, m, board[1000+1][1000+1], moves[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
bool visited[1000+1][1000+1];
queue<vector<int>> q;

int main()
{
    cin>>n>>m;

    for (int i=0;i<n;i++)
    {
        string str;
        cin>>str;

        for (int j=0;j<m;j++)
        {
            board[i][j] = str[j] == '1';

            if (i == 0 && !board[i][j])
            {
                q.push({i, j});
                visited[i][j] = true;
            }
        }
    }

    while (q.size())
    {
        vector<int> f = q.front();
        q.pop();

        for (int i=0;i<4;i++)
        {
            int x = f[0] + moves[i][0];
            int y = f[1] + moves[i][1];

            if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || board[x][y])
                continue;

            visited[x][y] = true;

            if (x == n-1)
            {
                cout << "YES";
                return 0;
            }

            q.push({x, y});
        }
    }

    cout << "NO";
}