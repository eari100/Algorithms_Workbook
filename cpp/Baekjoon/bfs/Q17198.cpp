#include <iostream>
#include <queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17198 (Bucket Brigade)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.11.16 (O)
 **/
int moves[4][2] = {{-1, 0}, {0, 1}, {1,0 }, {0, -1}};
char board[10][10];
queue<vector<int>> q;

int main()
{
    for (int i=0;i<10;i++)
    {
        for (int j=0;j<10;j++)
        {
            cin>>board[i][j];

            if (board[i][j] == 'L')
            {
                q.push({i, j, 0});
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

            if (x < 0|| x>=10 || y <0||y>=10)
            {
                continue;
            }

            if (board[x][y] == 'B')
            {
                cout<<f[2];
                return 0;
            }

            if (board[x][y] == '.')
            {
                board[x][y] = 'L';
                q.push({x, y, f[2]+1});
            }
        }
    }
}