#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14728 (벼락치기)
 * @classification: knapsack
 * @문제 푼 날짜 (자력으로 풂?): 26.04.07 (O)
 **/
int n, t;
int _time, score;
int max_score = 0;
int dp[10001]; // 시간-점수

int main()
{
    cin>>n>>t;

    for (int i=0;i<n;i++)
    {
        cin>>_time>>score;

        for (int j=t;j>=_time;j--)
        {
            int a = dp[j-_time]+score;
            if (a > dp[j])
            {
                dp[j] = a;
                max_score = max(max_score, dp[j]);
            }
        }
    }

    cout<<max_score;
}