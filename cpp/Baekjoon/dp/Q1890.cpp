#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1890 (점프)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.10.27 (O)
 **/
long long dp[100][100];
int n, board[100][100];

long long solve(int x, int y)
{
    if (dp[x][y] || !board[x][y])
    {
        return dp[x][y];
    }

    if (x+board[x][y] < n)
    {
        dp[x][y] += solve(x+board[x][y], y);
    }

    if (y+board[x][y] < n)
    {
        dp[x][y] += solve(x, y+board[x][y]);
    }

    return dp[x][y];
}

int main()
{
    cin>>n;
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            cin>>board[i][j];
        }
    }

    dp[n-1][n-1] = 1;
    cout << solve(0, 0);
}