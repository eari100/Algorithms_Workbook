#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11663 (선분 위의 점)
 * @classification: binary search
 * @문제 푼 날짜 (자력으로 풂?): 25.09.08 (X)
 **/
int n,m,l,r;
vector<int> dots;

int min_search(int x)
{
  int s = 0, e = n - 1;

  while (s <= e)
  {
    int mid = (s + e) / 2;

    if (x > dots[mid])
    {
      s = mid + 1;
    }
    else
    {
      e = mid - 1;
    }
  }

  return s;
}

int max_search(int x)
{
  int s = 0, e = n - 1;

  while (s <= e)
  {
    int mid = (s + e) / 2;

    if (x < dots[mid])
    {
      e = mid - 1;
    }
    else
    {
      s = mid + 1;
    }
  }

  return s;
}


int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  cin>>n>>m;
  dots.resize(n);

  for(int i=0;i<n;i++)
  {
    cin>>dots[i];
  }

  sort(dots.begin(),dots.end());

  for(int i=0;i<m;i++)
  {
    cin>>l>>r;
    cout << max_search(r) - min_search(l) << '\n';
  }
}