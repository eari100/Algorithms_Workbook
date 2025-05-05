#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/24444 (알고리즘 수업 - 너비 우선 탐색 1)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.05.06 (O)
 **/
int main()
{
  int n, m, r;
  cin >> n >> m >> r;
  int order = 1;

  int orders[100'000] = {0};
  vector<vector<int>> graph(n);

  while(m--)
  {
    int a, b;
    cin >> a >> b;

    graph[a-1].push_back(b-1);
    graph[b-1].push_back(a-1);
  }

  for(vector<int>& v : graph) {
    sort(v.begin(), v.end());
  }

  queue<int> q;
  q.push(r-1);
  orders[r-1] = order++;

  while(!q.empty())
  {
    int cur = q.front();
    q.pop();

    for (int& i : graph[cur]) {
      if (orders[i] > 0) continue;

      orders[i] = order++;
      q.push(i);
    }
  }

  for (int i=0;i<n;i++)
  {
    cout << orders[i] << '\n';
  }
}