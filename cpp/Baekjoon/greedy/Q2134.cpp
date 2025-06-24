#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2134 (창고 이전)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.05.21 (X)
 **/
long long cost = 0, move_box = 0, cnt1 = 0, cnt2 = 0, a[10001], b[10001], n, m, k;

int main()
{
  cin >> n >> m >> k;
  for(int i=0;i<n;i++)
  {
    cin >> a[i];
    cnt1 += a[i];
  }

  for(int i=0;i<m;i++)
  {
    cin >> b[i];
    cnt2 += b[i];
  }

  int i=0, j=0;

  while(cnt1 && cnt2)
  {
    if(!a[i])
    {
      i++;
      continue;
    }

    if (!b[j])
    {
      j++;
      continue;
    }

    ++move_box;
    cost += i+1 + j+1;
    a[i]--;
    b[j]--;
    cnt1--;
    cnt2--;
  }

  cout << move_box << " " << cost;
}
