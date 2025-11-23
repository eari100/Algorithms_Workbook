#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11055 (가장 큰 증가하는 부분 수열)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.11.23 (O)
 **/
int n, board[1000], dp[1000], _max = 0;

int main()
{
    cin>>n;

    for(int i=0;i<n;i++)
    {
        cin>>board[i];
        dp[i] = board[i];
        _max = max(_max, dp[i]);
    }

    for (int i=1;i<n;i++)
    {
        for (int j=0;j<i;j++)
        {
            if (board[i] > board[j])
            {
                int x = dp[j] + board[i];
                if (x > dp[i])
                {
                    dp[i] = x;
                }
            }
        }

        _max = max(_max, dp[i]);
    }

    cout << _max ;
}