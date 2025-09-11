#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/32217 (광선 다각형 만들기)
 * @classification: geometry
 * @문제 푼 날짜 (자력으로 풂?): 25.09.11 (O)
 **/
int n, tmp;

int main()
{
  cin>>n;
  int size = 180 + (180 * (n + 1 - 3));

  for(int i=0;i<n;i++)
  {
    cin>>tmp;
    size -= (tmp * 2);
  }

  cout<<size;
}