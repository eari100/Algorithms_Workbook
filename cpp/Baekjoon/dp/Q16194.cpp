#include<iostream>

using namespace std;

/**
* @source: https://www.acmicpc.net/problem/16194 (카드 구매하기 2)
* @classification: dp
* @문제 푼 날짜 (자력으로 풂?): 25.12.18 (O)
**/
int target, _data[1000+1], dp[1000+1];

int main()
{
    cin>>target;

    for (int i=1;i<=target;i++)
    {
        cin>>_data[i];
        dp[i] = _data[i];
    }

    for (int i=1;i<=target;i++)
    {
        for (int j=1;j<i;j++)
        {
            dp[i] = min(dp[i], dp[i-j]+_data[j]);
        }
    }

    cout<<dp[target];
}