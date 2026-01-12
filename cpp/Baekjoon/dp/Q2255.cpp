#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2225 (합분해)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 26.01.09 (X)
 **/
int n,k,MOD=1'000'000'000;
int dp[200+1][200+1];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n>>k;

    for (int j=1;j<=k;j++)
    {
        dp[1][j] = j;
    }

    for (int i=2;i<=n;i++)
    {
        for (int j=1;j<=k;j++)
        {
            dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
        }
    }

    cout<<dp[n][k];
}