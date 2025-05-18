#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11896 (다각형)
 * @classification: geometry
 * @문제 푼 날짜 (자력으로 풂?): 25.05.18 (X)
 **/
int main()
{
  int a, b;
  cin >> a >> b;

  long long sum = 0;

  for(int i=max(4, a);i<=b;i++)
  {
    if (i % 2 == 0)
    {
      sum += i;
    }
  }

  cout << sum;
}