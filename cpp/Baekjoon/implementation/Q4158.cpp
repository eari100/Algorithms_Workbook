#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/4158 (CD)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.07.04 (O)
 **/
int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int n, m, idx;

  while(1)
  {
    cin >> n >> m;

    if(n == 0 && m == 0)
    {
      break;
    }

    int cell = 0;
    vector<bool> cd(100'000'001, false);

    for(int i=0; i<n; i++)
    {
      cin >> idx;
      cd[idx] = true;
    }

    for(int i=0; i<m; i++)
    {
      cin >> idx;
      if(cd[idx])
      {
        ++cell;
      }
    }

    cout << cell << '\n';
  }
}