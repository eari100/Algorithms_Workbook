#include<iostream>


using namespace std;

long long memo[1000+1][1000+1], mod = 1'000'000'009, target, t_use;

/**
 * @source: https://www.acmicpc.net/problem/15992 (1, 2, 3 더하기 7)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.06.22 (O)
 **/
int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  for (int i=0; i<=1000; i++)
  {
    for (int j=0; j<=1000; j++)
    {
      if (i == 1 && (j >= 1 && j <= 3))
      {
        memo[i][j] = 1;
        continue;
      }

      memo[i][j] = 0;

      if (i < 2)
      {
        continue;
      }

      if (j-3 >= 1)
      {
        memo[i][j] += memo[i-1][j-3];
      }
      if (j-2 >= 1)
      {
        memo[i][j] += memo[i-1][j-2];
      }
      if (j-1 >= 1)
      {
        memo[i][j] += memo[i-1][j-1];
      }

      memo[i][j] %= mod;
    }
  }

  int t;
  cin>>t;

  while(t--)
  {
    cin>> target >> t_use;
    cout << memo[t_use][target] << '\n';
  }
}