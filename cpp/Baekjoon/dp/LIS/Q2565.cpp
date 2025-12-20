#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2565 (전깃줄)
 * @classification: LIS
 * @문제 푼 날짜 (자력으로 풂?): 25.12.21 (X)
 **/
int n, dp[100], max_dp=0;
vector<pair<int, int>> v;

int main()
{
    cin>>n;
    v.resize(n);

    for (int i=0;i<n;i++)
    {
        cin>>v[i].first>>v[i].second;
    }

    sort(v.begin(), v.end());

    for (int i=0;i<n;i++)
    {
        dp[i]=1;
        for (int j=0;j<i;j++)
        {
            if (dp[j]+1 > dp[i] && v[j].second < v[i].second)
            {
                dp[i] = dp[j]+1;
            }
        }
        max_dp=max(max_dp,dp[i]);
    }

    cout<<n-max_dp;
}