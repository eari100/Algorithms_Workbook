#include<iostream>
#include<set>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2294 (동전 2)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.05.18 (O)
 **/
int main()
{
  int n, k;
  cin>>n>>k;
  queue<vector<int>> _queue;
  set<int> coins;
  int dp[100001] = {0};

  for(int i=1;i<=n;i++)
  {
    int c;
    cin>>c;
    if(dp[c] > 0) continue;

    coins.insert(c);
    dp[c] = 1;
    vector<int> vec = {c, 1};
    _queue.push(vec);

    if (dp[k])
    {
      cout << 1;
      return 0;
    }
  }

  while (_queue.size())
  {
    vector<int> prev = _queue.front();
    _queue.pop();

    for (set<int>::iterator iter = coins.begin(); iter != coins.end(); iter++)
    {
      int next = prev[0] + *iter;

      if (next > k) continue;
      if (dp[next] > 0 && dp[next] <= prev[1] + 1) continue;

      dp[next] = prev[1] + 1;
      vector<int> vec = {next, prev[1] + 1};
      _queue.push(vec);
    }
  }

  cout << (dp[k] == 0 ? -1 : dp[k]);
}