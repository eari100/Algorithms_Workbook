#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2580 (스도쿠)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.10.11 (X)
 **/
int board[9][9];
vector<vector<int>> blank;

void print()
{
    for (int i=0;i<9;i++)
    {
        for (int j=0;j<9;j++)
        {
            cout<<board[i][j] << " ";
        }
        cout<<'\n';
    }
}

bool valid(int x, int y)
{
    int cols[10], rows[10], grps[10];

    for (int i=1;i<10;i++)
    {
        cols[i] = 0;
        rows[i] = 0;
        grps[i] = 0;
    }

    for (int j=0;j<9;j++)
    {
        int num1 = board[x][j], num2 = board[j][y];

        if (num1 > 0) cols[num1]++;
        if (num2 > 0) rows[num2]++;

        if ((num1 > 0 && cols[num1] == 2) || (num2 > 0 && rows[num2] == 2))
            return false;
    }

    int x2 = x/3 * 3, y2 = y/3 * 3;

    for (int i=x2;i<x2+3;i++)
    {
        for (int j=y2;j<y2+3;j++)
        {
            if (board[i][j] == 0)
                continue;

            grps[board[i][j]]++;

            if (grps[board[i][j]] == 2)
            {
                return false;
            }
        }
    }

    return true;
}

void bt(int curr)
{
    if (curr == blank.size())
    {
        print();
        exit(0);
    }

    for (int val=1;val<=9;val++)
    {
        board[blank[curr][0]][blank[curr][1]] = val;
        if (valid(blank[curr][0], blank[curr][1]))
        {
            bt(curr+1);
        }
    }
    board[blank[curr][0]][blank[curr][1]] = 0;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    for (int i=0;i<9;i++)
    {
        for (int j=0;j<9;j++)
        {
            cin>>board[i][j];

            if (board[i][j]==0)
            {
                blank.push_back({i, j});
            }
        }
    }

    bt(0);
}