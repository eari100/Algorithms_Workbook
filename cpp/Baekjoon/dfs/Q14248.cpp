#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14248 (점프 점프)
 * @classification: dfs
 * @문제 푼 날짜 (자력으로 풂?): 25.07.30 (O)
 **/
vector<int> stones;
vector<bool> visited;
int count = 0;

void dfs(int curr)
{
  ++count;

  int prev = curr - stones[curr];
  if(prev >= 0 && prev < stones.size() && !visited[prev])
  {
    visited[prev] = true;
    dfs(prev);
  }

  int next = curr + stones[curr];
  if(next >= 0 && next < stones.size() && !visited[next])
  {
    visited[next] = true;
    dfs(next);
  }
}

int main()
{
  int n, index;
  cin>>n;

  stones.resize(n);
  visited.resize(n);

  for(int i=0;i<n;i++) {
    cin >> stones[i];
    visited[i] = false;
  }

  cin >> index;

  dfs(index-1);

  cout << count;
}
