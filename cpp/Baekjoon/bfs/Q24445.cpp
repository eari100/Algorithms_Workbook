#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/24445 (알고리즘 수업 - 너비 우선 탐색 2)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.05.09 (O)
 **/
int main()
{
  int n, m, s, order = 1;
  cin>>n>>m>>s;

  vector<int> visited(n+1, 0);
  vector<vector<int>> graph(n+1);

  queue<int> que;

  for(int i=0;i<m;i++)
  {
    int a, b;
    cin >> a >> b;
    graph[a].push_back(b);
    graph[b].push_back(a);
  }

  for (vector<int>& v : graph)
  {
    sort(v.begin(), v.end(), greater<int>());
  }

  que.push(s);
  visited[s] = order++;

  while(!que.empty())
  {
    int _f = que.front();
    que.pop();

    for (int& node : graph[_f])
    {
      if (visited[node] == 0)
      {
        que.push(node);
        visited[node] = order++;
      }
    }
  }

  for (int i=1;i<=n;i++)
  {
    cout << visited[i] << '\n';
  }
}