#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2110 (공유기 설치)
 * @classification: binary-search
 * @문제 푼 날짜 (자력으로 풂?): 25.06.24 (X)
 **/
int main(void)
{
  int n, c, num, answer = 0;
  cin >> n >> c;
  vector<int> vec;

  for (int i = 0; i < n; i++)
  {
    cin >> num;
    vec.push_back(num);
  }

  sort(vec.begin(), vec.end());

  int str = 1, end = vec[n-1] - vec[0] ;

  while (str <= end)
  {
    int mid = (str + end) / 2, count = 1, prev = vec[0];

    for (int i=1;i<n;i++)
    {
      int curr = vec[i];

      if (curr - prev >= mid)
      {
        count++;
        prev = curr;
      }
    }

    if (count >= c)
    {
      answer = max(answer, mid);
      str = mid + 1;
    }
    else
    {
      end = mid - 1;
    }
  }

  cout << answer;

  return 0;
}