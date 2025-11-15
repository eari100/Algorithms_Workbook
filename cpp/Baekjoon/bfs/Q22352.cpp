#include<iostream>
#include<vector>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/22352 (항체 인식)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.11.15 (O)
 **/
int n, m, before[30][30], after[30][30], xx = -1, yy = -1;
int moves[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
vector<vector<int>> v;
queue<vector<int>> q;

int main()
{
    cin>>n>>m;

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            cin>>before[i][j];
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            cin>>after[i][j];
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            if (before[i][j]!=after[i][j])
            {
                if (xx == -1 && yy == -1)
                {
                    xx = after[i][j];
                    yy = before[i][j];
                }
                else
                {
                    if (xx != after[i][j] || yy != before[i][j])
                    {
                        cout << "NO";
                        return 0;
                    }
                }

                v.push_back({i, j});
            }
        }
    }

    if ( !v.size() )
    {
        cout << "YES";
        return 0;
    }

    before[v[0][0]][v[0][1]] = xx;
    q.push({v[0][0], v[0][1]});

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

            if (before[x][y] == yy)
            {
                before[x][y] = xx;
                q.push({x, y});
            }
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            if (before[i][j] != after[i][j])
            {
                cout << "NO";
                return 0;
            }
        }
    }

    cout << "YES";
}