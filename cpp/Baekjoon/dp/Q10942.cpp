#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/10942 (팰린드롬?)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.12.19 (X)
 **/
int n, m, nums[2000], s, e;
bool dp[2000][2000];

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n;

    for (int i=0;i<n;i++)
    {
        cin>>nums[i];
        dp[i][i] = true;

        if (i-1>=0 && nums[i-1]==nums[i])
        {
            dp[i-1][i] = true;
        }
    }

    for (int i=n-2;i>=0;i--)
    {
        for (int j=i+2;j<n;j++)
        {
            dp[i][j] = (nums[i] == nums[j]) && dp[i+1][j-1];
        }
    }

    cin>>m;

    for (int i=0;i<m;i++)
    {
        cin>>s>>e;
        s--;
        e--;

        cout<<(int)(dp[s][e])<<'\n';
    }
}