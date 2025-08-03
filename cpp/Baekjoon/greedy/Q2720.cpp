#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2720 (세탁소 사장 동혁)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.08.03 (O)
 **/
int main()
{
  int t, x, moneys[4] = {25, 10, 5, 1};
  cin>>t;
  while(t--)
  {
    cin>>x;
    int answers[4];

    for(int i=0;i<4;i++)
    {
      answers[i] = x / moneys[i];
      x %= moneys[i];
    }

    for(int a : answers)
    {
      cout<<a<<" ";
    }
    cout << '\n';
  }
}