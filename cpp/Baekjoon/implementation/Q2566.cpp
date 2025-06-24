#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2110 (공유기 설치)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.06.24 (O)
 **/
int main()
{
  long long _max = -1, x, a = 0, b = 0;

  for(int i=0;i<9;i++)
  {
    for(int j=0;j<9;j++)
    {
      cin>>x;
      if(x > _max)
      {
        _max = x;
        a = i + 1;
        b = j + 1;
      }
    }
  }

  cout << _max << '\n';
  cout << a << ' ' << b;
}