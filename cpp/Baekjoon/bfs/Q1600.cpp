#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1600 (말이 되고픈 원숭이)
 * @classification: bfs
 * @문제 푼 날짜 (자력솔?): 25.11.01 (O)
 **/
int k, h, w, min_dist = 4'00'005;
int moves1[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int moves2[8][2] = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

bool board[200][200], visited[200][200][30+1];
queue<vector<int>> q; // x, y, cost, k

int main()
{
    cin>>k;
    cin>>w>>h;

    for (int i=0;i<h;i++)
    {
        for (int j=0;j<w;j++)
        {
            cin>>board[i][j];
        }
    }

    q.push({0, 0, 0, k});
    for (int i=0;i<=k;i++)
    {
        visited[0][0][i] = true;
    }

    while (q.size())
    {
        vector<int> f = q.front();
        q.pop();

        if (f[0] == h-1 && f[1] == w-1)
        {
            min_dist = min(min_dist, f[2]);
            continue;
        }

        for (int i=0;i<4;i++)
        {
            int x = f[0] + moves1[i][0];
            int y = f[1] + moves1[i][1];

            if (x < 0 || x >= h || y < 0 || y >= w || board[x][y] || visited[x][y][f[3]])
            {
                continue;
            }

            visited[x][y][f[3]] = true;
            q.push({x, y, f[2]+1, f[3]});
        }

        if (f[3])
        {
            for (int i=0;i<8;i++)
            {
                int x = f[0] + moves2[i][0];
                int y = f[1] + moves2[i][1];

                if (x < 0 || x >= h || y < 0 || y >= w || board[x][y] || visited[x][y][f[3]-1])
                {
                    continue;
                }

                visited[x][y][f[3]-1] = true;
                q.push({x, y, f[2]+1, f[3]-1});
            }
        }
    }



    cout << (min_dist == 4'00'005 ? -1 : min_dist);
}