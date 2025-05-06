#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/9625 (BABBA)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.05.07 (O)
 **/
int main()
{
  int n;
  cin >> n;

  int dp[45+1][2];
  dp[0][0] = 1;
  dp[0][1] = 0;
  dp[1][0] = 0;
  dp[1][1] = 1;

  for(int i=2;i<=45;i++)
  {
    dp[i][0] = dp[i-1][0] + dp[i-2][0];
    dp[i][1] = dp[i-1][1] + dp[i-2][1];
  }

  cout << dp[n][0] << ' ' << dp[n][1];
}