#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/15988 (1, 2, 3 더하기 3)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.09.10 (O)
 **/
int t, x, MOD = 1'000'000'009, dp[1'000'001];

int main()
{
  cin>>t;
  dp[1] = 1;
  dp[2] = 2;
  dp[3] = 4;

  for (int i = 4; i <= 1'000'000; i++)
  {
    dp[i] = ((dp[i-1] + dp[i-2]) % MOD  + dp[i-3]) % MOD;
  }

  while(t--)
  {
    cin>>x;
    cout << dp[x] << '\n';
  }
}