#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/31670 (특별한 마법 공격)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.06.24 (X)
 **/
int main()
{
  int n, datas[100'000+1];
  long long dp[100'000+1][2];
  cin >> n;

  for(int i = 0; i < n; i++)
    cin >> datas[i];

  dp[0][0] = 0;
  dp[0][1] = datas[0];

  for(int i=1;i<n;i++)
  {
    dp[i][0] = dp[i-1][1];
    dp[i][1] = datas[i] + min(dp[i-1][0], dp[i-1][1]);
  }

  cout << min(dp[n-1][0], dp[n-1][1]);
}