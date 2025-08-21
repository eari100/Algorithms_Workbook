#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/15681 (트리와 쿼리)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.08.21(O)
 **/
vector<vector<int>> graph;
vector<int> visited;
vector<int> child;

int bt(int curr)
{
  child[curr] = 1;
  visited[curr] = 1;

  for(int next : graph[curr])
  {
    if(visited[next]) continue;

    child[curr] += bt(next);
  }

  return child[curr];
}

int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);\

  int n, r, q;
  cin >> n >> r >> q;

  graph.resize(n+1);
  visited.resize(n+1);
  child.resize(n+1);

  for(int i=0;i<n-1;i++)
  {
    int u,v;
    cin >> u >> v;
    graph[u].push_back(v);
    graph[v].push_back(u);
  }

  bt(r);

  for(int i=0;i<q;i++)
  {
    int x;
    cin >> x;

    cout << child[x] << '\n';
  }
}