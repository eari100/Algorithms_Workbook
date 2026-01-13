#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14499 (주사위 굴리기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 26.01.13 (O)
 **/
int r,c,x,y,cmd_cnt,cmd;
int board[20][20];
int dice[6+1];

void rotate(int cmd)
{
    // 동
    if (cmd==1)
    {
        int tmp = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = tmp;
    }
    // 서
    else if (cmd==2)
    {
        int tmp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = tmp;
    }
    // 북
    else if (cmd==3)
    {
        int tmp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = tmp;
    }
    // 남
    else if (cmd==4)
    {
        int tmp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = tmp;
    }
}

bool move_coordinate(int cmd)
{
    // 동
    if (cmd==1)
    {
        if (y+1 < c)
        {
            y++;
            return true;
        }
    }
    // 서
    else if (cmd==2)
    {
        if (y-1 >= 0)
        {
            y--;
            return true;
        }
    }
    // 북
    else if (cmd==3)
    {
        if (x-1 >= 0)
        {
            x--;
            return true;
        }
    }
    // 남
    else if (cmd==4)
    {
        if (x+1 < r)
        {
            x++;
            return true;
        }
    }

    return false;
}

int main()
{
    cin>>r>>c>>x>>y>>cmd_cnt;

    for (int i=0;i<r;i++)
    {
        for (int j=0;j<c;j++)
        {
            cin>>board[i][j];
        }
    }

    for (int i=0;i<cmd_cnt;i++)
    {
        cin>>cmd;

        if (move_coordinate(cmd))
        {
            rotate(cmd);

            if (board[x][y] == 0)
            {
                board[x][y] = dice[1];
            }
            else
            {
                dice[1] = board[x][y];
                board[x][y] = 0;
            }

            cout<<dice[6]<<'\n';
        }
    }
}