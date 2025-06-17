#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/15516 (Array Manipulation at Moloco (Easy))
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.06.17 (O)
 **/
int main()
{
  int n;
  cin >> n;

  int answers[1000+1] = {0,}, datas[1000+1] = {0,};

  for(int i=0;i<n;i++)
  {
    cin >> datas[i];

    for(int j=0;j<i;j++)
    {
      if(datas[j] < datas[i])
      {
        answers[i]++;
      }
    }
  }

  for(int i=0;i<n;i++)
  {
    cout << answers[i] << '\n';
  }
}