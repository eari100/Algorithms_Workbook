#include<iostream>
#include<vector>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11967 (불켜기)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.12.18 (O)
 **/
bool light[100][100];
bool touch[100][100];
bool visited[100][100];
vector<vector<int>> _switch[100][100];
int n,m;
int x,y,a,b;
int on=1, room=1;
int moves[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    light[0][0] = true;
    cin>>n>>m;

    for (int i=0;i<m;i++)
    {
        cin>>x>>y>>a>>b;
        x--;
        y--;
        a--;
        b--;
        _switch[x][y].push_back({a,b});
    }

    while (1)
    {
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                visited[i][j] = false;
            }
        }

        int tmp_room = 1;
        queue<pair<int,int>> q;
        q.push({0, 0});
        visited[0][0] = true;

        while (q.size())
        {
            pair<int, int> f = q.front();
            q.pop();

            if ( !touch[f.first][f.second] )
            {
                for (int j=0;j<_switch[f.first][f.second].size();j++)
                {
                    if (light[_switch[f.first][f.second][j][0]][_switch[f.first][f.second][j][1]])
                    {
                        continue;
                    }

                    light[_switch[f.first][f.second][j][0]][_switch[f.first][f.second][j][1]]=true;
                    on++;
                }

                touch[f.first][f.second] = true;
            }

            for (int i=0;i<4;i++)
            {
                int x = f.first + moves[i][0];
                int y = f.second + moves[i][1];

                if (x < 0 || x >= n || y < 0 || y >= n || !light[x][y] || visited[x][y])
                {
                    continue;
                }

                q.push({x, y});
                ++tmp_room;
                visited[x][y]=true;
            }
        }

        if (tmp_room == room)
        {
            break;
        }

        room = tmp_room;
    }

    cout<<on;
}