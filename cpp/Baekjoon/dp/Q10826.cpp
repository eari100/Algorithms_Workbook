#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/10826 (피보나치 수 4)
 * @classification: dp, arbitrary_precision
 * @문제 푼 날짜 (자력으로 풂?): 26.04.02 (O)
 **/
int dp[2][2500+1], n;
int sum[2500+1];

int main()
{
    cin>>n;

    if (n==0)
    {
        cout<<0;
        return 0;
    }
    else if (n==1)
    {
        cout<<1;
        return 0;
    }

    for (int i=0;i<2500+1;i++)
    {
        dp[0][i] = -1;
        dp[1][i] = -1;
        sum[i] = -1;
    }

    dp[0][2500] = 0;
    dp[1][2500] = 1;

    for (int i=2;i<=n;i++)
    {
        int next = 0;

        for (int j=2500;j>=0;j--)
        {
            if (dp[0][j] == -1 && dp[1][j] == -1 && next == 0)
            {
                break;
            }

            int a = dp[0][j] == -1 ? 0 : dp[0][j];
            int b = dp[1][j] == -1 ? 0 : dp[1][j];
            int s =  a + b + next;
            sum[j] = s % 10;

            if (s >= 10)
            {
                next = 1;
            }
            else
            {
                next = 0;
            }
        }

        int copy_idx = i%2;

        for (int j=0;j<2500+1;j++)
        {
            if (sum[j] != -1)
            {
                dp[copy_idx][j] = sum[j];
            }
        }
    }

    for (int i=0;i<2500+1;i++)
    {
        if (sum[i] == -1)
        {
            continue;
        }

        cout<<sum[i];
    }
}