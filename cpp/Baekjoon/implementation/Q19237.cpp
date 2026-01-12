#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/19237 (어른 상어)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 26.01.05 (O)
 **/
int n, m, k;
int board[20][20][2]; // 상어 번호, 남은 초
int shark_dir[400+1]; // 1부터 사용
int shark_point[400+1][2];
int LIMIT = 1000;
int _time = 0;
int tmp;
bool dead[400+1];
int shark_cnt;

// 1, 2, 3, 4
// 위, 아래, 왼, 오
int moves[4][2] =
{
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
};

int rules[400+1][4][4];

void update_smell()
{
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            if (board[i][j][0])
            {
                board[i][j][1]--;

                if ( !board[i][j][1] )
                {
                    board[i][j][0] = 0;
                }
            }
        }
    }
}

void move_shark()
{
    for (int i=m;i>=1;i--)
    {
        if (dead[i])
            continue;

        int _dir = shark_dir[i];

        for (int j=0;j<4;j++)
        {
            int _dir2 = rules[i][_dir][j];

            int x = shark_point[i][0] + moves[_dir2][0];
            int y = shark_point[i][1] + moves[_dir2][1];

            // 무냄새 이동
            if (x >= 0 && x < n && y >= 0 && y < n && board[x][y][0] == 0)
            {
                // board 갱신
                // board[x][y][0] = i;
                // board[x][y][1] = k;

                // 상어
                // 방향 갱신
                shark_dir[i] = _dir2;
                // 위치 갱신
                shark_point[i][0] = x;
                shark_point[i][1] = y;

                goto _skip;
            }
        }

        // 자기 냄새가 있는 곳으로
        for (int j=0;j<4;j++)
        {
            int _dir2 = rules[i][_dir][j];

            int x = shark_point[i][0] + moves[_dir2][0];
            int y = shark_point[i][1] + moves[_dir2][1];

            // 자기 냄새
            if (x >= 0 && x < n && y >= 0 && y < n && board[x][y][0] == i)
            {
                // 상어
                // 방향 갱신
                shark_dir[i] = _dir2;
                // 위치 갱신
                shark_point[i][0] = x;
                shark_point[i][1] = y;

                goto _skip;
            }
        }

        _skip:;
    }
}

void feast()
{
    for (int i=m;i>=1;i--)
    {
        if (dead[i])
            continue;

        // 자기보다 약한 상어가 존재
        if (board[shark_point[i][0]][shark_point[i][1]][0] && i < board[shark_point[i][0]][shark_point[i][1]][0])
        {
            dead[ board[shark_point[i][0]][shark_point[i][1]] [0]] = true;
            shark_cnt--;
        }

        board[shark_point[i][0]][shark_point[i][1]][0] = i;
        board[shark_point[i][0]][shark_point[i][1]][1] = k;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n>>m>>k;
    shark_cnt = m;

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            cin>>tmp;

            if (tmp)
            {
                board[i][j][0] = tmp;
                board[i][j][1] = k;
                shark_point[tmp][0] = i;
                shark_point[tmp][1] = j;
            }
        }
    }

    for (int i=1;i<m+1;i++)
    {
        cin>>shark_dir[i];
        shark_dir[i]--;
    }

    for (int i=1;i<m+1;i++)
    {
        for (int j=0;j<4;j++)
        {
            for (int k=0;k<4;k++)
            {
                cin>>rules[i][j][k];
                rules[i][j][k]--;
            }
        }
    }

    while (_time < LIMIT)
    {
        move_shark();
        update_smell();
        feast();
        _time++;

        if (shark_cnt == 1)
        {
            cout<<_time;
            return 0;
        }

        // cout<<_time<<" sec =========================="<<endl;
        //
        // for (int i=0;i<n;i++)
        // {
        //     for (int j=0;j<n;j++)
        //     {
        //         cout<<board[i][j][0]<<" ";
        //     }
        //     cout<<endl;
        // }
        //
        // cout<<"board end"<<endl;
        //
        // for (int i=1;i<=m;i++)
        // {
        //     cout<< "shark " << i << endl;
        //     cout<<"dead " << dead[i]<<endl;
        //     cout<< "dir : " << shark_dir[i] << endl;
        //     cout<< "point : " << shark_point[i][0] << ", " << shark_point[i][1] << endl;
        //     cout<<"~~~~~~~~~~~~~~"<<endl;
        // }
    }

    cout<<-1;
}