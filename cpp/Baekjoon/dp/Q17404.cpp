#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17404 (RGB거리 2)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.11.24 (O)
 **/
int n, board[1000][3], dp1[1000][3], dp2[1000][3], dp3[1000][3];
int INF = (1 << 31) - 1;
int min_val = INF;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n;

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<3;j++)
        {
            cin>>board[i][j];
        }
    }

    if (n == 1)
    {
        cout << min(min(board[0][0], board[0][1]), board[0][2]);
        return 0;
    }

    dp1[0][0] = INF;
    dp1[0][1] = board[0][1];
    dp1[0][2] = board[0][2];

    dp2[0][0] = board[0][0];
    dp2[0][1] = INF;
    dp2[0][2] = board[0][2];

    dp3[0][0] = board[0][0];
    dp3[0][1] = board[0][1];
    dp3[0][2] = INF;

    for (int i=1;i<n-1;i++)
    {
        dp1[i][0] = board[i][0] + min(dp1[i-1][1], dp1[i-1][2]);
        dp1[i][1] = board[i][1] + min(dp1[i-1][0], dp1[i-1][2]);
        dp1[i][2] = board[i][2] + min(dp1[i-1][0], dp1[i-1][1]);

        dp2[i][0] = board[i][0] + min(dp2[i-1][1], dp2[i-1][2]);
        dp2[i][1] = board[i][1] + min(dp2[i-1][0], dp2[i-1][2]);
        dp2[i][2] = board[i][2] + min(dp2[i-1][0], dp2[i-1][1]);

        dp3[i][0] = board[i][0] + min(dp3[i-1][1], dp3[i-1][2]);
        dp3[i][1] = board[i][1] + min(dp3[i-1][0], dp3[i-1][2]);
        dp3[i][2] = board[i][2] + min(dp3[i-1][0], dp3[i-1][1]);
    }

    dp1[n-1][0] = board[n-1][0] + min(dp1[n-2][1], dp1[n-2][2]);
    dp2[n-1][1] = board[n-1][1] + min(dp2[n-2][0], dp2[n-2][2]);
    dp3[n-1][2] = board[n-1][2] + min(dp3[n-2][0], dp3[n-2][1]);

    min_val = min(min_val, dp1[n-1][0]);
    min_val = min(min_val, dp2[n-1][1]);
    min_val = min(min_val, dp3[n-1][2]);

    cout << min_val;
}