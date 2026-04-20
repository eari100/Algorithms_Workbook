#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/4811 (알약)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 26.04.20 (O)
 **/
int n;
long long dp[31][31];

int main()
{
    dp[1][0] = 1;

    for (int w=1;w<=30;w++)
    {
        for(int h=0;h<=w;h++)
        {
            dp[w][h] += dp[w-1][h];

            if (h-1>=0)
            {
                dp[w][h] += dp[w][h-1];
            }
        }
    }

    while (1)
    {
        cin>>n;
        if (!n)
        {
            break;
        }

        cout<<dp[n][n]<<'\n';
    }
}