#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2210 (숫자판 점프)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.12.03 (O)
 **/
int board[5][5], answer = 0;
bool nums[1'000'000];
bool visited[6][5][5];
int moves[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};

void bt(int depth, int i, int j, int num)
{
    if (depth == 5)
    {
        if ( !nums[num] )
        {
            nums[num] = true;
            answer++;
        }

        return;
    }

    for (int m=0;m<4;m++)
    {
        int i2 = i + moves[m][0];
        int j2 = j + moves[m][1];

        if (i2 >= 0 && i2 < 5 && j2 >= 0 && j2 < 5 && !visited[depth+1][i2][j2])
        {
            visited[depth+1][i2][j2] = true;
            bt(depth+1, i2, j2, num*10 + board[i2][j2]);
            visited[depth+1][i2][j2] = false;
        }
    }
}

int main()
{
    for (int i=0; i<5; i++)
    {
        for (int j=0; j<5; j++)
        {
            cin>>board[i][j];
        }
    }

    for (int i=0;i<5;i++)
    {
        for (int j=0;j<5;j++)
        {
            visited[0][i][j] = true;
            bt(0, i, j, board[i][j]);
            visited[0][i][j] = false;
        }
    }

    cout << answer;
}