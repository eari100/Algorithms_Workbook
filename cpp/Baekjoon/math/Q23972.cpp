#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/23972 (악마의 제안)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 25.08.13 (O)
 **/
int main()
{
  long long n,k,y;
  cin>>k>>n;

  if (n == 1)
  {
    cout << -1;
  }
  else
  {
    y = (n * k) / (n - 1);

    if ((n * k) % (n - 1))
    {
      y++;
    }

    cout << y;
  }
}