#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/12971 (숫자 놀이)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.07.07 (O)
 **/
int main()
{
  int p1, p2, p3, x1, x2, x3;
  cin >> p1 >> p2 >> p3 >> x1 >> x2 >> x3;

  for(int i=1;i<=(p1*p2*p3);i++)
  {
    if(i % p1 == x1 && i % p2 == x2 && i % p3 == x3)
    {
      cout << i;
      return 0;
    }
  }

  cout << -1;
}