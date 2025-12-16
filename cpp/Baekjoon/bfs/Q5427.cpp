#include<iostream>
#include<queue>
#include<deque>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5427 (불)
 * @classification: bfs
 * @문제 푼 날짜 (자력솔?): 25.12.16 (O)
 **/
int t,w,h,sx,sy;
char board[1000][1000];
bool sangeun[1000][1000];
int moves[4][2] = {{-1,0}, {0,1}, {1,0}, {0,-1}};

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>t;

    while (t--)
    {
        deque<vector<int>> dq; // x, y, time, 불:0, 상근:1
        cin>>w>>h;
        bool impossible=true;

        for (int i=0;i<h;i++)
        {
            for (int j=0;j<w;j++)
            {
                cin>>board[i][j];
                sangeun[i][j]=false;

                if (board[i][j]=='@')
                {
                    sx=i;
                    sy=j;
                    sangeun[i][j]=true;
                }

                if (board[i][j]=='*')
                {
                    dq.push_back({i, j, 0, 0});
                }
            }
        }

        dq.push_back({sx, sy, 0, 1});

        while (dq.size())
        {
            vector<int> f = dq.front();
            dq.pop_front();
            bool is_fire = !f[3];

            if (!is_fire && (f[0]==0||f[0]==h-1||f[1]==0||f[1]==w-1))
            {
                cout<<(f[2]+1)<<'\n';
                impossible=false;
                break;
            }

            for (int i=0;i<4;i++)
            {
                int x = f[0]+moves[i][0];
                int y = f[1]+moves[i][1];

                if (x < 0 || x >= h || y < 0 || y >= w || board[x][y] == '#')
                {
                    continue;
                }

                if (is_fire)
                {
                    if (board[x][y] == '*')
                    {
                        continue;
                    }

                    board[x][y]='*';
                    dq.push_back({x, y, f[2]+1, f[3]});
                }
                else
                {
                    if (sangeun[x][y])
                    {
                        continue;
                    }

                    if (board[x][y]=='.')
                    {
                        sangeun[x][y]=true;
                        dq.push_back({x, y, f[2]+1, f[3]});
                    }
                }
            }
        }

        if (impossible)
        {
            cout<<"IMPOSSIBLE"<<'\n';
        }
    }
}