#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/9465 (스티커)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.08.03 (O)
 **/
int main()
{
  int n;
  cin >>n;
  while(n--)
  {
    int n;
    cin>>n;
    int x[n+2][2], dp[n+2][2];
    dp[0][0]=0;
    dp[0][1]=0;
    dp[1][0]=0;
    dp[1][1]=0;

    for(int i=2;i<n+2;i++)
    {
      cin>>x[i][0];
    }
    for(int i=2;i<n+2;i++)
    {
      cin>>x[i][1];
    }

    for(int i=2;i<n+2;i++)
    {
      int ppmax = max(dp[i-2][0], dp[i-2][1]);
      dp[i][0] = max(ppmax, dp[i-1][1]) + x[i][0];
      dp[i][1] = max(ppmax, dp[i-1][0]) + x[i][1];
    }

    cout << max(dp[n+1][0], dp[n+1][1]) << '\n';
  }
}