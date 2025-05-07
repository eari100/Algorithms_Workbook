#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/30236 (증가 수열)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.05.07 (O)
 **/
int main()
{
  int t;
  cin>>t;

  while(t--)
  {
    int len;
    cin >> len;
    int b = 0;
    for(int i=0;i<len;i++)
    {
      int x;
      cin>>x;

      if (++b == x)
      {
        ++b;
      }
    }

    cout<<b<<'\n';
  }
}