#include <iostream>
#include <set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14381 (숫자세는 양 (Small))
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.03.09 (O)
 **/
int main()
{
  int t, n;

  cin >> t;

  for (int i = 1; i <= t; i++)
  {
    cin >> n;

    if (n == 0)
    {
      cout << "Case #" << i << ": INSOMNIA" << '\n';
      continue;
    }

    set<int> s;
    int count = 1, last;

    while (s.size() < 10)
    {
      int mul = n * count;
      last = mul;

      while (mul > 0)
      {
        s.insert(mul % 10);
        mul /= 10;
      }

      count++;
    }

    cout << "Case #" << i << ": " << last << '\n';
  }
}