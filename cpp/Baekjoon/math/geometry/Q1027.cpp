#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1027 (고층 건물)
 * @classification: geometry
 * @문제 푼 날짜 (자력으로 풂?): 25.07.30 (X, 고층 건물 투과 관측 가능한 줄 알았음. 지문이 명확하지 않음)
 **/
int main()
{
  int n, answer = 0;
  cin>>n;
  int buildings[n], checked[n];

  for(int i=0;i<n;i++)
  {
    cin>>buildings[i];
    checked[i] = 0;
  }

  for(int i=0;i<n-1;i++)
  {
    double _max = -1'000'000'000.0;
    for(int j=i+1;j<n;j++)
    {
      double inclination = (double)(buildings[i] - buildings[j]) / (i - j);
      if (inclination > _max)
      {
        checked[i]++;
        checked[j]++;
        _max = inclination;

        answer = max(max(answer, checked[i]), checked[j]);
      }
    }
  }

  cout<<answer;
}