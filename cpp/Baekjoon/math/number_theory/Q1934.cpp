#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1934 (최소공배수)
 * @classification: number theory
 * @문제 푼 날짜 (자력으로 풂?): 25.05.03 (X)
 **/
int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int t;
  cin>>t;

  while(t--)
  {
    int a, b, c = 1;
    cin>>a>>b;

    if (a == b)
    {
      cout << a << '\n';
      continue;
    }

    for (int i=min(a, b);i>=2;i--)
    {
      if (a%i==0 && b%i==0)
      {
        c = i;
        break;
      }
    }

    cout <<  c * (a/c) * (b/c) << '\n';
  }
}