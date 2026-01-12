#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/20057 (마법사 상어와 토네이도)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 26.01.07 (X, 독해력 이슈)
 **/
int n, board[499][499];
int move_idx=0;
int moves[4][2] = {{0,-1},{1,0},{0,1},{-1,0}};
int x,y;
int move_cnt=1; // power 측정을 위한 val
int out_sand=0;
bool is_out_of_board(int x, int y)
{
    return x<0||x>=n||y<0||y>=n;
}

// x,y,percent
int cal[4][9][3] =
{
{
        {-2,0, 2},
        {-1,-1, 10}, {-1,0, 7}, {-1,1, 1},
        {0,-2, 5},
        {1,-1, 10}, {1,0, 7}, {1,1, 1},
        {2,0, 2}
    },

{
        {0,-2, 2},
        {-1,-1, 1}, {0,-1, 7}, {1,-1, 10},
        {2,0, 5},
        {-1,1, 1}, {0,1, 7}, {1,1, 10},
        {0,2, 2}
    },

{
        {-2,0, 2},
        {-1,-1, 1}, {-1,0, 7}, {-1,1, 10},
        {0,2, 5},
        {1,-1, 1}, {1,0, 7}, {1,1, 10},
        {2,0, 2}
    },

{
    {0,-2, 2},
    {-1,-1, 10}, {0,-1, 7}, {1,-1, 1},
    {-2,0, 5},
    {-1,1, 10}, {0,1, 7}, {1,1, 1},
    {0,2, 2}
    },
};

// 한 방향으로 가는 파워
int get_power(int move_cnt)
{
    return move_cnt/2 + move_cnt%2;
}

int get_move_sand(int total, int persent)
{
    if (!total)
    {
        return 0;
    }

    return (int) (total * persent / 100);
}

void solve()
{
    //cout<< "tornado: "<< x << ", " << y << endl;
    int except_alpha = 0;

    for (int j=0;j<9;j++)
    {
        int cal_x = x+cal[move_idx][j][0];
        int cal_y = y+cal[move_idx][j][1];
        int move_sand = get_move_sand(board[x][y], cal[move_idx][j][2]);
        except_alpha+=move_sand;

        if (is_out_of_board(cal_x, cal_y))
        {
            out_sand += move_sand;
        }
        else
        {
            board[cal_x][cal_y] += move_sand;
        }
    }

    int alp_x = x + moves[move_idx][0];
    int alp_y = y + moves[move_idx][1];
    int move_sand = board[x][y] - except_alpha;

    if (is_out_of_board(alp_x, alp_y))
    {
        out_sand += move_sand;
    }
    else
    {
        board[alp_x][alp_y] += move_sand;
    }

    board[x][y] = 0;

    // todo: cout
    // for (int i=0;i<n;i++)
    // {
    //     for (int j=0;j<n;j++)
    //     {
    //         cout<<board[i][j]<<" ";
    //     }
    //     cout<<endl;
    // }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    // test code
    // for (int i=1;i<=10;i++)
    // {
    //     cout<<"move cnt " << i << ": " << get_power(i) << endl;
    // }

    // test code


    cin>>n;

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            cin>>board[i][j];
        }
    }

    int mid = (n-1)/2;
    x = mid;
    y = mid;

    while (x != 0 || y != 0)
    {
        int power = get_power(move_cnt);

        for (int i=0;i<power;i++)
        {
            if (x == 0 && y == 0)
            {
                cout<<out_sand;
                return 0;
            }

            x += moves[move_idx][0];
            y += moves[move_idx][1];
            solve();
        }

        move_cnt++;

        move_idx++;
        move_idx%=4;
    }
}