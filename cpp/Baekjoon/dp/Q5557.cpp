#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5557 (1학년)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 26.01.04 (X)
 **/
long long n, dp[20+1][100], target, nums[100];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n;

    for (int i=0;i<n-1;i++)
    {
        cin>>nums[i];
    }

    cin>>target;

    dp[nums[0]][0] = 1;

    for (int i=1;i<n-1;i++)
    {
        long long curr = nums[i];

        for (int j=0;j<=20;j++)
        {
            long long m = j - curr;
            long long p = j + curr;

            if (m >= 0 && m <= 20 && dp[m][i-1])
            {
                dp[j][i] += dp[m][i-1];
            }

            if (p >= 0 && p <= 20)
            {
                dp[j][i] += dp[p][i-1];
            }
        }
    }

    cout<<dp[target][n-2];
}