#include<iostream>
#include<queue>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/18808 (스티커 붙이기)
 * @classification: implementation
 * @문제 푼 날짜 (자력솔?): 25.12.15 (O)
 **/
int n, m, k, r, c, answer;
bool board[40][40];
bool stickers[10][10], tmp_stk[10][10], visited[10][10];
int point[2];
int moves[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};

void rotate()
{
    for (int i=0;i<10;i++)
    {
        for (int j=0;j<10;j++)
        {
            tmp_stk[j][9-i] = stickers[i][j];
        }
    }

    for (int i=0;i<10;i++)
    {
        for (int j=0;j<10;j++)
        {
            stickers[i][j] = tmp_stk[i][j];
        }
    }

    int x = point[0];
    point[0]=point[1];
    point[1]=9-x;
}

bool attach(int x1, int y1, int x2, int y2)
{
    for (int i=0;i<10;i++)
    {
        for (int j=0;j<10;j++)
        {
            visited[i][j]=false;
        }
    }

    if (board[x1][y1])
    {
        return false;
    }

    vector<pair<int,int>> tmp;
    queue<pair<int, int>> q1, q2;
    q1.push({x1, y1});
    q2.push({x2, y2});
    visited[x2][y2]=true;
    tmp.push_back({x1, y1});

    while (q1.size())
    {
        pair<int, int> f1 = q1.front();
        q1.pop();

        pair<int, int> f2 = q2.front();
        q2.pop();

        for (int i=0;i<4;i++)
        {
            int x22 = f2.first + moves[i][0];
            int y22 = f2.second + moves[i][1];

            if (x22 < 0 || x22 >= 10 || y22 < 0 || y22 >= 10 || visited[x22][y22] || !stickers[x22][y22])
            {
                continue;
            }

            int x11 = f1.first + moves[i][0];
            int y11 = f1.second + moves[i][1];

            if (x11 < 0 || x11 >= n || y11 < 0 || y11 >= m || board[x11][y11])
            {
                return false;
            }

            q1.push({x11, y11});
            q2.push({x22, y22});
            visited[x22][y22]=true;
            tmp.push_back({x11, y11});
        }
    }

    for (pair<int, int> p : tmp)
    {
        board[p.first][p.second]=true;
    }

    return true;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>m>>k;

    for (int i=0;i<k;i++)
    {
        cin>>r>>c;
        int sticker_size=0;

        for (int j=0;j<10;j++)
        {
            for (int k2=0;k2<10;k2++)
            {
                stickers[j][k2]=false;
            }
        }

        for (int j=0;j<r;j++)
        {
            for (int k2=0;k2<c;k2++)
            {
                cin>>stickers[j][k2];
                sticker_size+=stickers[j][k2];

                if (stickers[j][k2])
                {
                    point[0]=j;
                    point[1]=k2;
                }
            }
        }


        for (int j=0;j<4;j++)
        {
            if (j)
            {
                rotate();
            }

            for (int h=0;h<n;h++)
            {
                for (int w=0;w<m;w++)
                {
                    if (attach(h, w, point[0], point[1]))
                    {
                        //_print();
                        answer+=sticker_size;
                        goto sticker_end;
                    }
                }
            }
        }

        sticker_end:;
    }

    cout<<answer;
}