#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1744 (수 묶기)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.08.01 (O)
 **/
int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int n, answer = 0;
  cin>>n;
  int l = -1, r = n;
  vector<int> vec(n);

  for(int i=0;i<n;i++)
  {
    cin>>vec[i];
  }

  sort(vec.begin(), vec.end());

  // left move
  while(l < r)
  {
    // 범위 넘음 or 양수가 포함됨
    if( (l+2) >= n || vec[l+2] > 0)
    {
      break;
    }

    answer += (vec[l+1] * vec[l+2]);
    l += 2;
  }

  // right move
  while(l < r)
  {
    // 범위 넘음 or 양수가 아님
    if( (r-2) < 0 || vec[r-2] <= 1)
    {
      break;
    }

    answer += (vec[r-1] * vec[r-2]);
    r -= 2;
  }

  // 나머지 합치기
  for(int i=l+1;i<=r-1;i++)
  {
    answer += vec[i];
  }

  cout << answer;
}