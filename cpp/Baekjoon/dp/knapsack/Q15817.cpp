#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/15817 (배수 공사)
 * @classification: knapsack
 * @문제 푼 날짜 (자력솔?): 25.12.02 (X)
 **/
int n, x, wood, cnt;
int dp[10000+1];

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>x;
    dp[0] = 1;

    for (int i=0;i<n;i++)
    {
        cin>>wood>>cnt;

        for (int cur=x;cur>=0;cur--)
        {
            for (int c=1;c<=cnt;c++)
            {
                int prev = cur - (wood * c);

                if (prev >= 0)
                {
                    dp[cur] += dp[prev];
                }
            }
        }
    }

    cout<<dp[x];
}