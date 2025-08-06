#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/26145 (출제비 재분배)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.08.06 (O)
 **/
int main()
{
  int n, m, tmp;
  cin>>n>>m;
  int money[n+m];
  for(int i=0;i<n;i++)
  {
    cin>>money[i];
  }

  for (int i=n;i<n+m;i++)
  {
    money[i]=0;
  }

  for(int i=0;i<n;i++)
  {
    for(int j=0;j<n+m;j++)
    {
      cin>>tmp;
      money[i] -= tmp;
      money[j] += tmp;
    }
  }

  for (int& m : money)
  {
    cout<< m << ' ';
  }
}