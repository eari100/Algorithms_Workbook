#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14923 (미로 탈출)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.11.04 (O)
 **/
int h, w;
int _str[2], _end[2], board[1000][1000];
int visited[1000][1000][2];
queue<vector<int>> q;
int moves[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int answer = 1'000'005;

int main()
{
    cin>>h>>w;
    cin>>_str[0]>>_str[1];
    cin>>_end[0]>>_end[1];
    --_str[0];
    --_str[1];
    --_end[0];
    --_end[1];

    for (int i=0;i<h;i++)
    {
        for (int j=0;j<w;j++)
        {
            cin>>board[i][j];
        }
    }

    q.push({_str[0], _str[1], 1, 1});
    visited[_str[0]][_str[1]][1] = 1;
    visited[_str[0]][_str[1]][0] = 1;

    while (q.size())
    {
        vector<int> f = q.front();
        q.pop();

        if (f[0] == _end[0] && f[1] == _end[1])
        {
            continue;
        }

        for (int i=0;i<4;i++)
        {
            int x = f[0] + moves[i][0];
            int y = f[1] + moves[i][1];

            if (x < 0 || x >= h || y < 0 || y >= w)
            {
                continue;
            }

            if (!board[x][y]) // 빈칸
            {
                if (!visited[x][y][f[3]]) // 방문 x
                {
                    q.push({x, y, f[2]+1, f[3]});
                    visited[x][y][f[3]] = f[2] + 1;
                }
            }
            else // 벽
            {
                if (f[3]) // 마법을 안썼다면
                {
                    q.push({x, y, f[2]+1, 0});
                    visited[x][y][0] = f[2] + 1;
                }
            }
        }
    }

    if (visited[_end[0]][_end[1]][0])
    {
        answer = min(answer, visited[_end[0]][_end[1]][0]);
    }

    if (visited[_end[0]][_end[1]][1])
    {
        answer = min(answer, visited[_end[0]][_end[1]][1]);
    }

    cout << (answer == 1'000'005 ? -1 : (answer-1));
}