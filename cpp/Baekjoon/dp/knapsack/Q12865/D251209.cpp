#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/12865 (평범한 배낭)
 * @classification: knapsack
 * @문제 푼 날짜 (자력으로 풂?): 25.12.09 (O)
 **/
int n, k, w[100+1], v[100+1], dp[100'000+1], answer = 0;

int main()
{
    cin>>n>>k;

    for (int i=0;i<n;i++)
    {
        cin>>w[i]>>v[i];
    }

    for (int i=0;i<n;i++)
    {
        for (int j=k;j>=w[i];j--)
        {
            dp[j] = max(dp[j], dp[j-w[i]] + v[i]);
            answer= max(answer, dp[j]);
        }
    }

    cout<<answer;
}