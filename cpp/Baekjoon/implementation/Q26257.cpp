#include <iostream>
#include <set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/26257 (std::shared_ptr)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.07.02 (O)
 **/
int main()
{
  int n, m, q, x, y, cnt = 0, pointers[200001];
  bool checked[200001] = {false};
  cin >> n >> m >> q;

  for(int i = 1; i <= m; i++)
  {
    cin >> pointers[i];
  }

  for(int i = 1; i <= q; i++)
  {
    string query;
    cin >> query;

    if(query == "assign")
    {
      cin >> x >> y;
      pointers[x] = pointers[y];
    }
    else if(query == "swap")
    {
      cin >> x >> y;
      int swap = pointers[x];
      pointers[x] = pointers[y];
      pointers[y] = swap;
    }
    else
    {
      cin >> x;
      pointers[x] = 0;
    }
  }

  for (int i=1;i<=m;i++)
  {
    if ( !checked[pointers[i]] && pointers[i] )
    {
      checked[pointers[i]] = true;
      ++cnt;
    }
  }

  cout << cnt << '\n';

  for (int i=1;i<=n;i++)
  {
    if (checked[i])
    {
      cout << i << '\n';
    }
  }
}